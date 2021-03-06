/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.compare.diagram.diagramdiff.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diagram.diagramdiff.DiagramDiffExtension;
import org.eclipse.emf.compare.diagram.diagramdiff.DiagramModelElementChange;
import org.eclipse.emf.compare.diagram.diagramdiff.DiagramModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diagram.diagramdiff.DiagramdiffPackage;
import org.eclipse.emf.compare.diff.merge.IMerger;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DiffPackage;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChange;
import org.eclipse.emf.compare.diff.metamodel.impl.ModelElementChangeLeftTargetImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram Model Element Change Left Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.compare.diagram.diagramdiff.impl.DiagramModelElementChangeLeftTargetImpl#getSemanticDiff <em>Semantic Diff</em>}</li>
 *   <li>{@link org.eclipse.emf.compare.diagram.diagramdiff.impl.DiagramModelElementChangeLeftTargetImpl#getHideElements <em>Hide Elements</em>}</li>
 *   <li>{@link org.eclipse.emf.compare.diagram.diagramdiff.impl.DiagramModelElementChangeLeftTargetImpl#isIsCollapsed <em>Is Collapsed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramModelElementChangeLeftTargetImpl extends ModelElementChangeLeftTargetImpl implements DiagramModelElementChangeLeftTarget {
	/**
	 * The cached value of the '{@link #getSemanticDiff() <em>Semantic Diff</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemanticDiff()
	 * @generated
	 * @ordered
	 */
	protected ModelElementChange semanticDiff;

	/**
	 * The cached value of the '{@link #getHideElements() <em>Hide Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHideElements()
	 * @generated
	 * @ordered
	 */
	protected EList<DiffElement> hideElements;

	/**
	 * The default value of the '{@link #isIsCollapsed() <em>Is Collapsed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCollapsed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COLLAPSED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCollapsed() <em>Is Collapsed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCollapsed()
	 * @generated
	 * @ordered
	 */
	protected boolean isCollapsed = IS_COLLAPSED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramModelElementChangeLeftTargetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramdiffPackage.Literals.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementChange getSemanticDiff() {
		if (semanticDiff != null && semanticDiff.eIsProxy()) {
			InternalEObject oldSemanticDiff = (InternalEObject)semanticDiff;
			semanticDiff = (ModelElementChange)eResolveProxy(oldSemanticDiff);
			if (semanticDiff != oldSemanticDiff) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__SEMANTIC_DIFF, oldSemanticDiff, semanticDiff));
			}
		}
		return semanticDiff;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementChange basicGetSemanticDiff() {
		return semanticDiff;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemanticDiff(ModelElementChange newSemanticDiff) {
		ModelElementChange oldSemanticDiff = semanticDiff;
		semanticDiff = newSemanticDiff;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__SEMANTIC_DIFF, oldSemanticDiff, semanticDiff));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiffElement> getHideElements() {
		if (hideElements == null) {
			hideElements = new EObjectWithInverseResolvingEList.ManyInverse<DiffElement>(DiffElement.class, this, DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__HIDE_ELEMENTS, DiffPackage.DIFF_ELEMENT__IS_HIDDEN_BY);
		}
		return hideElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsCollapsed() {
		return isCollapsed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCollapsed(boolean newIsCollapsed) {
		boolean oldIsCollapsed = isCollapsed;
		isCollapsed = newIsCollapsed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__IS_COLLAPSED, oldIsCollapsed, isCollapsed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visit(DiffModel diffModel) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMerger provideMerger() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__HIDE_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getHideElements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__HIDE_ELEMENTS:
				return ((InternalEList<?>)getHideElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__SEMANTIC_DIFF:
				if (resolve) return getSemanticDiff();
				return basicGetSemanticDiff();
			case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__HIDE_ELEMENTS:
				return getHideElements();
			case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__IS_COLLAPSED:
				return isIsCollapsed();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__SEMANTIC_DIFF:
				setSemanticDiff((ModelElementChange)newValue);
				return;
			case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__HIDE_ELEMENTS:
				getHideElements().clear();
				getHideElements().addAll((Collection<? extends DiffElement>)newValue);
				return;
			case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__IS_COLLAPSED:
				setIsCollapsed((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__SEMANTIC_DIFF:
				setSemanticDiff((ModelElementChange)null);
				return;
			case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__HIDE_ELEMENTS:
				getHideElements().clear();
				return;
			case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__IS_COLLAPSED:
				setIsCollapsed(IS_COLLAPSED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__SEMANTIC_DIFF:
				return semanticDiff != null;
			case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__HIDE_ELEMENTS:
				return hideElements != null && !hideElements.isEmpty();
			case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__IS_COLLAPSED:
				return isCollapsed != IS_COLLAPSED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DiagramModelElementChange.class) {
			switch (derivedFeatureID) {
				case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__SEMANTIC_DIFF: return DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE__SEMANTIC_DIFF;
				default: return -1;
			}
		}
		if (baseClass == AbstractDiffExtension.class) {
			switch (derivedFeatureID) {
				case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__HIDE_ELEMENTS: return DiffPackage.ABSTRACT_DIFF_EXTENSION__HIDE_ELEMENTS;
				case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__IS_COLLAPSED: return DiffPackage.ABSTRACT_DIFF_EXTENSION__IS_COLLAPSED;
				default: return -1;
			}
		}
		if (baseClass == DiagramDiffExtension.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DiagramModelElementChange.class) {
			switch (baseFeatureID) {
				case DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE__SEMANTIC_DIFF: return DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__SEMANTIC_DIFF;
				default: return -1;
			}
		}
		if (baseClass == AbstractDiffExtension.class) {
			switch (baseFeatureID) {
				case DiffPackage.ABSTRACT_DIFF_EXTENSION__HIDE_ELEMENTS: return DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__HIDE_ELEMENTS;
				case DiffPackage.ABSTRACT_DIFF_EXTENSION__IS_COLLAPSED: return DiagramdiffPackage.DIAGRAM_MODEL_ELEMENT_CHANGE_LEFT_TARGET__IS_COLLAPSED;
				default: return -1;
			}
		}
		if (baseClass == DiagramDiffExtension.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isCollapsed: "); //$NON-NLS-1$
		result.append(isCollapsed);
		result.append(')');
		return result.toString();
	}

} //DiagramModelElementChangeLeftTargetImpl
