/*******************************************************************************
 * Copyright (c) 2006, 2007 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.tests.unit.core.util.modelutils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Launches all the JUnit tests for the {@link ModelUtils} class.
 * 
 * @author Laurent Goubet <a href="mailto:laurent.goubet@obeo.fr">laurent.goubet@obeo.fr</a>
 */
@SuppressWarnings("nls")
public class ModelUtilsTestSuite extends TestCase {
	/**
	 * Launches the test with the given arguments.
	 * 
	 * @param args
	 *            Arguments of the testCase.
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * Creates the {@link junit.framework.TestSuite TestSuite} for all the tests.
	 * 
	 * @return The test suite containing all the tests.
	 */
	public static Test suite() {
		final TestSuite suite = new TestSuite("Tests for the ModelUtils behavior");
		suite.addTestSuite(TestAttachResource.class);
		suite.addTestSuite(TestGetModelsFrom.class);
		suite.addTestSuite(TestLoadFromFile.class);
		suite.addTestSuite(TestLoadFromInputStream.class);
		suite.addTestSuite(TestSaveSerialize.class);
		return suite;
	}
}
