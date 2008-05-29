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
package org.eclipse.emf.compare.tests.unit.core.util;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.tests.EMFCompareTestPlugin;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.compare.util.ModelUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EModelElementItemProvider;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;

/**
 * Tests the convenience methods provided by {@link AdapterUtils}.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
@SuppressWarnings("nls")
public class AdapterUtilsTest extends TestCase {
	/** References the location of an ecore model. */
	private static final String ECORE_MODEL_PATH = '/' + EMFCompareTestPlugin.PLUGIN_ID + '/'
			+ "inputs/attribute/attributeChange/v2.ecore";

	/** References the location of a UML model. */
	private static final String EMFDIFF_MODEL_PATH = '/' + EMFCompareTestPlugin.PLUGIN_ID + '/'
			+ "inputs/emfdiff/v1.emfdiff";

	/**
	 * This will be instantiated in {@link #setUp()}, it will hold the EObject loaded from
	 * {@link #ECORE_MODEL_PATH}.
	 */
	private EObject ecoreModel;

	/**
	 * This will be instantiated in {@link #setUp()}, it will hold the EObject loaded from
	 * {@link #EMFDIFF_MODEL_PATH}.
	 */
	private EObject emfdiffModel;

	/**
	 * Tests the adaptation of an ecore model element to a supported type.
	 */
	public void testValidAdaptEcore() {
		final TreeIterator<EObject> ecoreIterator = ecoreModel.eAllContents();
		while (ecoreIterator.hasNext()) {
			final EObject next = ecoreIterator.next();
			final IStructuredItemContentProvider contentProvider = AdapterUtils.adapt(next,
					IStructuredItemContentProvider.class);
			final IItemLabelProvider labelProvider = AdapterUtils.adapt(next, IItemLabelProvider.class);
			final IItemPropertySource propertySource = AdapterUtils.adapt(next, IItemPropertySource.class);
			assertNotNull("Couldn't find a content provider for ecore.", contentProvider);
			assertNotNull("Couldn't find a label provider for ecore.", labelProvider);
			assertNotNull("Couldn't find a property source for ecore.", propertySource);
			assertTrue("Adapted content provider is not an ecore IStructuredItemContentProvider.",
					contentProvider instanceof EModelElementItemProvider);
			assertTrue("Adapted label provider is not an ecore IItemLabelProvider.",
					labelProvider instanceof EModelElementItemProvider);
			assertTrue("Adapted property source is not an ecore IItemPropertySource.",
					propertySource instanceof EModelElementItemProvider);
		}
	}

	/**
	 * Tests the adaptation of an emfdiff model element to a supported type.
	 */
	public void testValidAdaptEmfdiff() {
		final TreeIterator<EObject> emfdiffIterator = emfdiffModel.eAllContents();
		while (emfdiffIterator.hasNext()) {
			final EObject next = emfdiffIterator.next();
			final IStructuredItemContentProvider contentProvider = AdapterUtils.adapt(next,
					IStructuredItemContentProvider.class);
			final IItemLabelProvider labelProvider = AdapterUtils.adapt(next, IItemLabelProvider.class);
			final IItemPropertySource propertySource = AdapterUtils.adapt(next, IItemPropertySource.class);
			assertNotNull("Couldn't find a content provider for emfdiff.", contentProvider);
			assertNotNull("Couldn't find a label provider for emfdiff.", labelProvider);
			assertNotNull("Couldn't find a property source for emfdiff.", propertySource);

			final String diffProviderPackage = "org.eclipse.emf.compare.diff.provider";
			final String matchProviderPackage = "org.eclipse.emf.compare.match.metamodel.provider";
			assertTrue("Adapted content provider is not an emfdiff IStructuredItemContentProvider.",
					contentProvider.getClass().getCanonicalName().startsWith(diffProviderPackage) || contentProvider.getClass().getCanonicalName().startsWith(matchProviderPackage));
			assertTrue("Adapted label provider is not an emfdiff IItemLabelProvider.", labelProvider
					.getClass().getCanonicalName().startsWith(diffProviderPackage) || labelProvider.getClass().getCanonicalName().startsWith(matchProviderPackage));
			assertTrue("Adapted property source is not an emfdiff IItemPropertySource.", propertySource
					.getClass().getCanonicalName().startsWith(diffProviderPackage) || propertySource.getClass().getCanonicalName().startsWith(matchProviderPackage));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws IOException {
		// IOException should never be throw. Check ModelUtilsTest if it is.
		ecoreModel = ModelUtils.load(ECORE_MODEL_PATH, new ResourceSetImpl());
		emfdiffModel = ModelUtils.load(EMFDIFF_MODEL_PATH, new ResourceSetImpl());
	}
}