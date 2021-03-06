/*******************************************************************************
 * Copyright (c) 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.tests.merge.dependencies;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.compare.diff.merge.service.MergeService;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.tests.merge.MergeTestBase;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.junit.Test;

public class DependenciesMergeTest extends MergeTestBase {

	UMLDependenciesMergeInputData input = new UMLDependenciesMergeInputData();

	@Test
	public void testModelElementChangeLeft1() throws Exception {
		leftModel = input.getOriginalModelElementChangeLeft();
		rightModel = input.getModifiedModelElementChangeLeft();
		doPerformTest(true);
	}

	@Test
	public void testModelElementChangeLeft2() throws Exception {
		leftModel = input.getOriginalModelElementChangeLeft();
		rightModel = input.getModifiedModelElementChangeLeft();
		doPerformTest(false);
	}

	@Test
	public void testReferenceChangeLeftTarget1() throws Exception {
		leftModel = input.getOriginalReferenceChangeLeftTarget();
		rightModel = input.getModifiedReferenceChangeLeftTarget();
		doPerformTest(true);
	}

	@Test
	public void testReferenceChangeLeftTarget2() throws Exception {
		leftModel = input.getOriginalReferenceChangeLeftTarget();
		rightModel = input.getModifiedReferenceChangeLeftTarget();
		doPerformTest(false);
	}

	@Test
	public void testReferenceChangeLeftRightTarget1() throws Exception {
		leftModel = input.getOriginalReferenceChangeLeftRightTarget();
		rightModel = input.getModifiedReferenceChangeLeftRightTarget();
		doPerformTest(true);
	}

	@Test
	public void testReferenceChangeLeftRightTarget2() throws Exception {
		leftModel = input.getOriginalReferenceChangeLeftRightTarget();
		rightModel = input.getModifiedReferenceChangeLeftRightTarget();
		doPerformTest(false);
	}

	@Test
	public void testUpdateReferenceLeftAndRight1() throws Exception {
		leftModel = input.getOriginalUpdateReferenceLeftAndRight();
		rightModel = input.getModifiedUpdateReferenceLeftAndRight();
		doPerformTest(true);
	}

	@Test
	public void testUpdateReferenceLeftAndRight2() throws Exception {
		leftModel = input.getOriginalUpdateReferenceLeftAndRight();
		rightModel = input.getModifiedUpdateReferenceLeftAndRight();
		doPerformTest(false);
	}

	@Test
	public void testUpdateReferenceLeft1() throws Exception {
		leftModel = input.getOriginalUpdateReferenceLeft();
		rightModel = input.getModifiedUpdateReferenceLeft();
		doPerformTest(true);
	}

	@Test
	public void testUpdateReferenceLeft2() throws Exception {
		leftModel = input.getOriginalUpdateReferenceLeft();
		rightModel = input.getModifiedUpdateReferenceLeft();
		doPerformTest(false);
	}

	@Override
	protected void assertResult(boolean isLeftToRight, EObject testLeftModel, EObject testRightModel)
			throws IOException {
		String leftModelString = serialize(testLeftModel);
		String rightModelString = serialize(testRightModel);
		String expected = leftModelString;
		String actual = rightModelString;
		if (!isLeftToRight) {
			expected = rightModelString;
			actual = leftModelString;
		}

		assertEquals(expected, actual);
	}

	public static String serialize(EObject root) throws IOException {
		final StringWriter writer = new StringWriter();
		final Map<String, String> options = new EMFCompareMap<String, String>();
		((XMLResource)root.eResource()).save(writer, options);
		final String result = writer.toString();
		writer.flush();
		return result;
	}

	@Override
	protected void checkMerge(boolean isLeftToRight, EObject testLeftModel, EObject testRightModel,
			List<DiffElement> differences) throws Exception {
		int initialDifferencesSize = differences.size();
		int differencesSize = 0;
		int nbInputDiffs = 0;
		Iterator<DiffElement> diffs = differences.iterator();
		// Merge only differences which require others differences.
		while (diffs.hasNext()) {
			EObject obj = diffs.next();
			if (obj instanceof DiffElement && ((DiffElement)obj).getRequires().size() > 0) {
				nbInputDiffs++;
				DiffModel model = getDiffModel((DiffElement)obj);
				MergeService.merge((DiffElement)obj, isLeftToRight);
				differencesSize = model.getDifferences().size();
				if (differencesSize != 0) {
					/*
					 * The merge of the difference has - either involved the merge of the required one (-2) -
					 * either not because not necessary (-1)
					 */
					assertTrue(differencesSize <= initialDifferencesSize - 1);
				}
			}
		}
		assertTrue("Differences with requires link expected", nbInputDiffs > 0); //$NON-NLS-1$
		if (differencesSize == 0 && nbInputDiffs > 0) {
			assertResult(isLeftToRight, testLeftModel, testRightModel);
		}
	}

	private DiffModel getDiffModel(DiffElement diff) {
		EObject container = diff.eContainer();
		if (container instanceof DiffModel) {
			return (DiffModel)container;
		} else if (container instanceof DiffElement) {
			return getDiffModel((DiffElement)container);
		}
		return null;
	}
}
