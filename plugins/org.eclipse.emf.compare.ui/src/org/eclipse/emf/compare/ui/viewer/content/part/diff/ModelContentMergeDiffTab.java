/*******************************************************************************
 * Copyright (c) 2006, 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.ui.viewer.content.part.diff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.diff.metamodel.ConflictingDiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DifferenceKind;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.util.DiffAdapterFactory;
import org.eclipse.emf.compare.ui.util.EMFAdapterFactoryProvider;
import org.eclipse.emf.compare.ui.util.EMFCompareConstants;
import org.eclipse.emf.compare.ui.util.EMFCompareEObjectUtils;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.IModelContentMergeViewerTab;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabItem;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

/**
 * Represents the tree view under a {@link ModelContentMergeTabFolder}'s diff tab.
 * 
 * @author Laurent Goubet <a href="mailto:laurent.goubet@obeo.fr">laurent.goubet@obeo.fr</a>
 */
public class ModelContentMergeDiffTab extends TreeViewer implements IModelContentMergeViewerTab {
	/** <code>int</code> representing this viewer part side. */
	protected final int partSide;

	/** Maps DiffElements to the TreeItems' data. The key used is the URI of the data. */
	private final Map<String, DiffElement> dataToDiff = new EMFCompareMap<String, DiffElement>();

	/** Maps a TreeItem to its data. The key used is the URI of the data. */
	private final Map<String, ModelContentMergeTabItem> dataToItem = new EMFCompareMap<String, ModelContentMergeTabItem>();

	/** Keeps a reference to the containing tab folder. */
	private final ModelContentMergeTabFolder parent;

	/**
	 * Creates a tree viewer under the given parent control.
	 * 
	 * @param parentComposite
	 *            The parent {@link Composite} for this tree viewer.
	 * @param side
	 *            Side of this viewer part.
	 * @param parentFolder
	 *            Parent folder of this tab.
	 */
	public ModelContentMergeDiffTab(Composite parentComposite, int side,
			ModelContentMergeTabFolder parentFolder) {
		super(new Tree(parentComposite, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL));
		partSide = side;
		parent = parentFolder;

		setUseHashlookup(true);
		setContentProvider(new AdapterFactoryContentProvider(EMFAdapterFactoryProvider.getAdapterFactory()));
		setLabelProvider(new TreeLabelProvider(EMFAdapterFactoryProvider.getAdapterFactory()));
		getTree().addPaintListener(new TreePaintListener());
	}

	/**
	 * Returns a {@link List} of the selected elements.
	 * 
	 * @return {@link List} of the selected elements.
	 */
	public List<TreeItem> getSelectedElements() {
		return Arrays.asList(getTree().getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ui.viewer.content.part.IModelContentMergeViewerTab#getUIItem(org.eclipse.emf.ecore.EObject)
	 */
	public ModelContentMergeTabItem getUIItem(EObject data) {
		ModelContentMergeTabItem result = null;
		// If the diff is hidden by another (diff extension), the item won't be returned
		final DiffElement diff = dataToDiff.get(EcoreUtil.getURI(data).fragment());
		if (diff != null && DiffAdapterFactory.shouldBeHidden(diff))
			return result;

		final ModelContentMergeTabItem item = dataToItem.get(EcoreUtil.getURI(data).fragment());

		// perfect matches, we'll search the first visible element in its tree path
		final Item treeItem = getVisibleAncestorOf(item.getVisibleItem());
		if (treeItem == item.getVisibleItem()) {
			// This is actually a perfect match : the item is visible in the tree and it is the actual
			// item displayed by the diff
			result = item;
		} else {
			// The item corresponding to the diff is not visible. We'll wrap its first visible ancestor.
			result = new ModelContentMergeTabItem(item.getActualItem(), treeItem, item.getCurveColor());
		}

		// we should have found an item. sets the curve width and Y coordinate
		final int curveY;
		if (result.getActualItem() == result.getVisibleItem()) {
			if (partSide == EMFCompareConstants.LEFT && diff instanceof ModelElementChangeRightTarget)
				curveY = ((TreeItem)result.getVisibleItem()).getBounds().y
						+ ((TreeItem)result.getVisibleItem()).getBounds().height;
			else if (partSide == EMFCompareConstants.RIGHT && diff instanceof ModelElementChangeLeftTarget)
				curveY = ((TreeItem)result.getVisibleItem()).getBounds().y
						+ ((TreeItem)result.getVisibleItem()).getBounds().height;
			else
				curveY = ((TreeItem)result.getVisibleItem()).getBounds().y
						+ ((TreeItem)result.getVisibleItem()).getBounds().height / 2;
			result.setCurveY(curveY);
		} else {
			if (partSide == EMFCompareConstants.LEFT && diff instanceof ModelElementChangeRightTarget)
				curveY = ((TreeItem)result.getVisibleItem()).getBounds().y
						+ ((TreeItem)result.getVisibleItem()).getBounds().height;
			else if (partSide == EMFCompareConstants.RIGHT && diff instanceof ModelElementChangeLeftTarget)
				curveY = ((TreeItem)result.getVisibleItem()).getBounds().y
						+ ((TreeItem)result.getVisibleItem()).getBounds().height;
			else
				curveY = ((TreeItem)result.getVisibleItem()).getBounds().y
						+ ((TreeItem)result.getVisibleItem()).getBounds().height;
			result.setCurveY(curveY);
		}
		if (getSelectedElements().contains(result.getActualItem()))
			result.setCurveSize(2);
		else
			result.setCurveSize(1);

		return result;
	}

	/**
	 * Returns a list of all the {@link Tree tree}'s visible elements.
	 * 
	 * @return List containing all the {@link Tree tree}'s visible elements.
	 */
	public List<ModelContentMergeTabItem> getVisibleElements() {
		final List<ModelContentMergeTabItem> result = new ArrayList<ModelContentMergeTabItem>();
		// This will happen if the user has "merged all"
		if (parent.getDiffAsList().size() == 0)
			return result;
		
		final List<Item> visibleTreeItems = getVisibleTreeItems();
		final Iterator<String> diffDatas = dataToItem.keySet().iterator();
		while (diffDatas.hasNext()) {
			final String data = diffDatas.next();
			final ModelContentMergeTabItem nextItem = dataToItem.get(data);
			final ModelContentMergeTabItem nextVisibleItem = getUIItem((EObject)nextItem.getActualItem()
					.getData());
			if (visibleTreeItems.contains(nextVisibleItem.getVisibleItem())) {
				final ModelContentMergeTabItem next = new ModelContentMergeTabItem(nextItem.getActualItem(),
						nextVisibleItem.getVisibleItem(), nextItem.getCurveColor(), nextVisibleItem
								.getCurveY(), nextVisibleItem.getCurveSize());
				result.add(next);
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ui.viewer.content.part.IModelContentMergeViewerTab#redraw()
	 */
	public void redraw() {
		getTree().redraw();
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.jface.viewers.ColumnViewer#refresh(java.lang.Object, boolean)
	 */
	@Override
	public void refresh(Object element, boolean updateLabels) {
		super.refresh(element, updateLabels);
		mapDifferences();
		mapTreeItems();
	}

	/**
	 * Modifies the input of this viewer. Sets a new label provider adapted to the given {@link EObject}.
	 * 
	 * @param eObject
	 *            New input of this viewer.
	 */
	public void setReflectiveInput(EObject eObject) {
		// We *need* to invalidate the cache here since setInput() would try to use it otherwise
		dataToDiff.clear();
		dataToItem.clear();
		
		final ComposedAdapterFactory adapterFactory = EMFAdapterFactoryProvider.getAdapterFactory();
		final AdapterFactory best = AdapterUtils.findAdapterFactory(eObject);
		if (best != null)
			adapterFactory.addAdapterFactory(best);
		setLabelProvider(new TreeLabelProvider(adapterFactory));
		setInput(eObject.eResource());
		
		mapDifferences();
		mapTreeItems();
	}

	/**
	 * Ensures the first element of the given list of items is visible in the tree, and sets the tree's
	 * selection to this list.
	 * 
	 * @param items
	 *            Items to make visible.
	 */
	public void showItems(List<DiffElement> items) {
		final List<EObject> datas = new ArrayList<EObject>();
		for (int i = 0; i < items.size(); i++) {
			if (partSide == EMFCompareConstants.ANCESTOR && items.get(i) instanceof ConflictingDiffElement)
				datas.add(((ConflictingDiffElement)items.get(i)).getOriginElement());
			else if (partSide == EMFCompareConstants.LEFT)
				datas.add(EMFCompareEObjectUtils.getLeftElement(items.get(i)));
			else
				datas.add(EMFCompareEObjectUtils.getRightElement(items.get(i)));
		}
		setSelection(new StructuredSelection(datas), true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see StructuredViewer#setSelectionToWidget(List, boolean)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void setSelectionToWidget(List l, boolean reveal) {
		// Will expand the treeItem to one level below the current if needed
		final List<TreeItem> newSelection = new ArrayList<TreeItem>();
		for (Object data : l) {
			Widget widget = null;
			if (data instanceof EObject)
				widget = findItemForEObject((EObject)data);
			else if (data instanceof TreePath)
				widget = findItemForEObject((EObject)((TreePath)data).getLastSegment());
			else if (data != null)
				widget = findItem(data);
			if (widget != null && widget instanceof TreeItem) {
				newSelection.add((TreeItem)widget);
				if (((TreeItem)widget).getExpanded() && getChildren(widget).length > 0)
					expandToLevel(data, 1);
			}
		}
		if (newSelection.size() > 0)
			setSelection(newSelection);
		else
			super.setSelectionToWidget(l, reveal);
	}

	/**
	 * Returns the Item corresponding to the given EObject or its container if none can be found.
	 * 
	 * @param element
	 *            {@link EObject} to seek in the tree.
	 * @return The Item corresponding to the given EObject.
	 */
	private Widget findItemForEObject(EObject element) {
		Widget result = super.findItem(element);
		if (result == null) {
			if (element.eContainer() != null) {
				result = findItemForEObject(element.eContainer());
			} else if (getTree().getItemCount() > 0)
				result = getTree().getItem(0);
		}
		if (result instanceof Tree && getTree().getItemCount() > 0)
			result = getTree().getItem(0);
		return result;
	}

	/**
	 * Returns a visible ancestor of the given item. Will return the first container that is not expanded.
	 * 
	 * @param item
	 *            item we look for a visible ancestor of.
	 * @return The first container of <tt>item</tt> that is not expanded, the element itself if its
	 *         container is expanded.
	 */
	private Item getVisibleAncestorOf(Item item) {
		Item result = item;
		final TreePath path = getTreePathFromItem(item);
		if (path.getSegmentCount() > 1) {
			for (int i = path.getSegmentCount() - 2; i >= 0; i--) {
				if (((TreeItem)findItem(path.getSegment(i))).getExpanded()) {
					result = (TreeItem)findItem(path.getSegment(i + 1));
					break;
				}
				if (i == 0)
					result = (TreeItem)findItem(path.getSegment(0));
			}
		}
		return result;
	}

	/**
	 * Returns a list of all the {@link Tree tree}'s visible elements.
	 * 
	 * @return List containing all the {@link Tree tree}'s visible elements.
	 */
	private List<Item> getVisibleTreeItems() {
		final TreeItem topItem = getTree().getTopItem();
		if (topItem != null) {
			// We won't go further down than the visible height of the tree,
			// yet we will take the whole width into account when searching for elements.
			final int treeHeight = getTree().getClientArea().height;
			final int treeWidth = getTree().getBounds().width;
			final int itemHeight = topItem.getBounds().height;
			final int itemWidth = topItem.getBounds().width;
			final List<Item> visibleItems = new ArrayList<Item>(treeHeight / itemHeight + 1);

			visibleItems.add(topItem);

			// The loop will start at the element directly following the "top" one,
			// And we'll go down to one item more than there are in the tree
			final int loopStart = topItem.getBounds().y + itemHeight + itemHeight / 2;
			final int loopEnd = treeHeight;
			for (int i = loopStart; i <= loopEnd; i += itemHeight) {
				TreeItem next = null;
				// we'll try and seek on all the line, thus increasing x on each iteration
				for (int xCoord = topItem.getBounds().x; xCoord < treeWidth; xCoord += itemWidth >> 1) {
					next = getTree().getItem(new Point(xCoord, i));
					// We found the item, it is unnecessary to probe any further on the line
					if (next != null)
						break;
				}
				if (next != null) {
					visibleItems.add(next);
				} else {
					// We did not found an item, it is thus useless to probe any further down
					break;
				}
			}

			return visibleItems;
		}
		return new ArrayList<Item>();
	}

	/**
	 * Maps the input's differences if any.
	 */
	private void mapDifferences() {
		dataToDiff.clear();
		final Iterator<DiffElement> diffIterator = parent.getDiffAsList().iterator();
		while (diffIterator.hasNext()) {
			final DiffElement diff = diffIterator.next();
			final EObject data;
			if (partSide == EMFCompareConstants.ANCESTOR && diff instanceof ConflictingDiffElement)
				data = ((ConflictingDiffElement)diff).getOriginElement();
			else if (partSide == EMFCompareConstants.LEFT)
				data = EMFCompareEObjectUtils.getLeftElement(diff);
			else
				data = EMFCompareEObjectUtils.getRightElement(diff);
			dataToDiff.put(EcoreUtil.getURI(data).fragment(), diff);
		}
	}

	/**
	 * This will map all the TreeItems in this TreeViewer that need be taken into account when drawing diff
	 * markers to a corresponding ModelContentMergeTabItem. This will allow us to browse everything once and
	 * for all.
	 */
	private void mapTreeItems() {
		dataToItem.clear();
		final TreePath[] expandedState = getExpandedTreePaths();
		expandAll();
		for (String key : dataToDiff.keySet()) {
			final DiffElement diff = dataToDiff.get(key);
			// Defines the TreeItem corresponding to this difference
			final EObject data;
			if (partSide == EMFCompareConstants.ANCESTOR && diff instanceof ConflictingDiffElement)
				data = ((ConflictingDiffElement)diff).getOriginElement();
			else if (partSide == EMFCompareConstants.LEFT)
				data = EMFCompareEObjectUtils.getLeftElement(diff);
			else
				data = EMFCompareEObjectUtils.getRightElement(diff);
			final Item actualItem = (Item)findItem(data);
			Item visibleItem = null;

			if (partSide == EMFCompareConstants.LEFT && diff instanceof ModelElementChangeRightTarget) {
				// in the case of a modelElementChangeRightTarget, we know we can't find
				// the element itself, we'll then search for one with the same index
				final EObject right = ((ModelElementChangeRightTarget)diff).getRightElement();
				final EObject left = ((ModelElementChangeRightTarget)diff).getLeftParent();
				final int rightIndex = right.eContainer().eContents().indexOf(right);
				// Ensures we cannot trigger ArrayOutOfBounds exeptions
				final int leftIndex = Math.min(rightIndex - 1, left.eContents().size() - 1);
				if (left.eContents().size() > 0)
					visibleItem = (Item)findItem(left.eContents().get(leftIndex));
			} else if (partSide == EMFCompareConstants.RIGHT && diff instanceof ModelElementChangeLeftTarget) {
				// in the case of a modelElementChangeLeftTarget, we know we can't find
				// the element itself, we'll then search for one with the same index
				final EObject right = ((ModelElementChangeLeftTarget)diff).getRightParent();
				final EObject left = ((ModelElementChangeLeftTarget)diff).getLeftElement();
				final int leftIndex = left.eContainer().eContents().indexOf(left);
				// Ensures we cannot trigger ArrayOutOfBounds exeptions
				final int rightIndex = Math.max(0, Math.min(leftIndex - 1, right.eContents().size() - 1));
				if (right.eContents().size() > 0)
					visibleItem = (Item)findItem(right.eContents().get(rightIndex));
			}

			// and now the color which should be used for this kind of differences
			final String color;
			if (diff.getKind() == DifferenceKind.CONFLICT || diff.isConflicting()) {
				color = EMFCompareConstants.PREFERENCES_KEY_CONFLICTING_COLOR;
			} else if (diff.getKind() == DifferenceKind.ADDITION) {
				color = EMFCompareConstants.PREFERENCES_KEY_ADDED_COLOR;
			} else if (diff.getKind() == DifferenceKind.DELETION) {
				color = EMFCompareConstants.PREFERENCES_KEY_REMOVED_COLOR;
			} else
				color = EMFCompareConstants.PREFERENCES_KEY_CHANGED_COLOR;

			final ModelContentMergeTabItem wrappedItem;
			if (visibleItem != null)
				wrappedItem = new ModelContentMergeTabItem(actualItem, visibleItem, color);
			else
				wrappedItem = new ModelContentMergeTabItem(actualItem, color);
			dataToItem.put(EcoreUtil.getURI(data).fragment(), wrappedItem);
		}
		setExpandedElements(expandedState);
	}

	/**
	 * This implementation of {@link PaintListener} handles the drawing of blocks around modified members in
	 * the tree tab.
	 * 
	 * @author Laurent Goubet <a href="mailto:laurent.goubet@obeo.fr">laurent.goubet@obeo.fr</a>
	 */
	class TreePaintListener implements PaintListener {
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.swt.events.PaintListener#paintControl(org.eclipse.swt.events.PaintEvent)
		 */
		public void paintControl(PaintEvent event) {
			if (ModelContentMergeViewer.shouldDrawDiffMarkers()) {
				for (ModelContentMergeTabItem item : getVisibleElements()) {
					drawRectangle(event, item);
				}
			}
		}

		/**
		 * Handles the drawing itself.
		 * 
		 * @param event
		 *            {@link PaintEvent} that triggered this operation.
		 * @param item
		 *            Item that need to be circled and connected to the center part.
		 */
		private void drawRectangle(PaintEvent event, ModelContentMergeTabItem item) {
			final Rectangle treeBounds = getTree().getClientArea();
			final Rectangle treeItemBounds = ((TreeItem)item.getVisibleItem()).getBounds();

			// Defines the circling Color
			final RGB color = ModelContentMergeViewer.getColor(item.getCurveColor());

			// We add a margin before the rectangle to circle the "+" as well as the tree line.
			final int margin = 60;

			// Defines all variables needed for drawing the rectangle.
			final int rectangleX = treeItemBounds.x - margin;
			final int rectangleY = treeItemBounds.y;
			final int rectangleWidth = treeItemBounds.width + margin;
			final int rectangleHeight = treeItemBounds.height - 1;
			final int rectangleArcWidth = 5;
			final int rectangleArcHeight = 5;

			// Performs the actual drawing
			event.gc.setLineWidth(item.getCurveSize());
			event.gc.setForeground(new Color(getTree().getDisplay(), color));
			if (partSide == EMFCompareConstants.LEFT) {
				if (item.getCurveY() != treeItemBounds.y + treeItemBounds.height / 2) {
					event.gc.setLineStyle(SWT.LINE_SOLID);
					event.gc.drawLine(rectangleX, item.getCurveY(), treeBounds.width + treeBounds.x, item
							.getCurveY());
				} else {
					event.gc.setLineStyle(SWT.LINE_DASHDOT);
					event.gc.drawRoundRectangle(rectangleX, rectangleY, rectangleWidth, rectangleHeight,
							rectangleArcWidth, rectangleArcHeight);
					event.gc.setLineStyle(SWT.LINE_SOLID);
					event.gc.drawLine(rectangleX + rectangleWidth, item.getCurveY(), treeBounds.width
							+ treeBounds.x, item.getCurveY());
				}
			} else if (partSide == EMFCompareConstants.RIGHT) {
				if (item.getCurveY() != treeItemBounds.y + treeItemBounds.height / 2) {
					event.gc.setLineStyle(SWT.LINE_SOLID);
					event.gc.drawLine(rectangleX + rectangleWidth, item.getCurveY(), treeBounds.x, item
							.getCurveY());
				} else {
					event.gc.setLineStyle(SWT.LINE_DASHDOT);
					event.gc.drawRoundRectangle(rectangleX, rectangleY, rectangleWidth, rectangleHeight,
							rectangleArcWidth, rectangleArcHeight);
					event.gc.setLineStyle(SWT.LINE_SOLID);
					event.gc.drawLine(rectangleX, item.getCurveY(), treeBounds.x, item.getCurveY());
				}
			} else {
				if (item.getCurveY() != treeItemBounds.y + treeItemBounds.height / 2) {
					event.gc.setLineStyle(SWT.LINE_SOLID);
					event.gc.drawLine(rectangleX + rectangleWidth, item.getCurveY(), rectangleX, item
							.getCurveY());
				} else {
					event.gc.setLineStyle(SWT.LINE_DASHDOT);
					event.gc.drawRoundRectangle(rectangleX, item.getCurveY(), rectangleWidth, item
							.getCurveY(), rectangleArcWidth, rectangleArcHeight);
				}
			}
		}
	}

	/**
	 * Label provider used by the tree control of this part.
	 * 
	 * @author Laurent Goubet <a href="mailto:laurent.goubet@obeo.fr">laurent.goubet@obeo.fr</a>
	 */
	private class TreeLabelProvider extends AdapterFactoryLabelProvider {
		/**
		 * Instantiates this label provider given its {@link AdapterFactory}.
		 * 
		 * @param theAdapterFactory
		 *            Adapter factory providing this {@link LabelProvider}'s text and images.
		 */
		public TreeLabelProvider(AdapterFactory theAdapterFactory) {
			super(theAdapterFactory);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see AdapterFactoryLabelProvider#getImage(Object)
		 */
		@Override
		public Image getImage(Object object) {
			Image image = super.getImage(object);
			if (image == null && object instanceof EObject) {
				EMFAdapterFactoryProvider.addAdapterFactoryFor((EObject)object);
				image = super.getImage(object);
			}
			return image;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see AdapterFactoryLabelProvider#getText(Object)
		 */
		@Override
		public String getText(Object object) {
			String text = super.getText(object);
			if (text == null && object instanceof EObject) {
				EMFAdapterFactoryProvider.addAdapterFactoryFor((EObject)object);
				text = super.getText(object);
			}
			return text;
		}
	}
}