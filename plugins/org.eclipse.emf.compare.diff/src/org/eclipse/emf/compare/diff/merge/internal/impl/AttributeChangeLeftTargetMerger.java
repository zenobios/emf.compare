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
package org.eclipse.emf.compare.diff.merge.internal.impl;

import org.eclipse.emf.compare.EMFComparePlugin;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.merge.api.DefaultMerger;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Merger for an {@link AttributeChangeLeftTarget} operation.<br/>
 * <p>
 * Are considered for this merger :
 * <ul>
 * <li>{@link RemoveAttribute}</li>
 * <li>{@link RemoteAddAttribute}</li>
 * </ul>
 * </p>
 * 
 * @author Cedric Brun <a href="mailto:cedric.brun@obeo.fr">cedric.brun@obeo.fr</a>
 */
public class AttributeChangeLeftTargetMerger extends DefaultMerger {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#applyInOrigin()
	 */
	@Override
	public void applyInOrigin() {
		/*
		 * FIXME [bug #209521] if we're merging an attribute pointing to an UnmatchedElement (namely, a
		 * deleted or remotely added datatype), we should merge its corresponding DeleteModelElement (or
		 * RemoteAddModelElement) beforehand. In the current state, we're doing a hard-link between the two
		 * models.
		 */
		final AttributeChangeLeftTarget theDiff = (AttributeChangeLeftTarget)this.diff;
		final EObject origin = theDiff.getLeftElement();
		final EObject element = theDiff.getLeftTarget();
		final EAttribute attr = theDiff.getAttribute();
		try {
			EFactory.eRemove(origin, attr.getName(), element);
		} catch (FactoryException e) {
			EMFComparePlugin.log(e, true);
		}
		super.applyInOrigin();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#undoInTarget()
	 */
	@Override
	public void undoInTarget() {
		/*
		 * FIXME [bug #209521] if we're merging an attribute pointing to an UnmatchedElement (namely, an added
		 * or remotely deleted datatype), we should merge its corresponding AddModelElement (or
		 * RemoteDeleteModelElement) beforehand. In the current state, we're doing a hard-link between the two
		 * models.
		 */
		final AttributeChangeLeftTarget theDiff = (AttributeChangeLeftTarget)this.diff;
		final EObject target = theDiff.getRightElement();
		final EObject element = theDiff.getLeftTarget();
		final EObject newOne = EcoreUtil.copy(element);
		final EAttribute attr = theDiff.getAttribute();
		try {
			EFactory.eAdd(target, attr.getName(), newOne);
			copyXMIID(element, newOne);
		} catch (FactoryException e) {
			EMFComparePlugin.log(e, true);
		}
		super.undoInTarget();
	}
}