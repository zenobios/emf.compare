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
package org.eclipse.emf.compare.uml2.diff.internal.extension.sequence;

import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffPackage;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.uml2.diff.UML2DiffEngine;
import org.eclipse.emf.compare.uml2.diff.internal.extension.AbstractDiffExtensionFactory;
import org.eclipse.emf.compare.uml2diff.UML2DiffFactory;
import org.eclipse.emf.compare.uml2diff.UMLMessageChangeLeftTarget;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Factory for UMLMessageChangeLeftTarget.
 * 
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public class UMLMessageChangeLeftTargetFactory extends AbstractDiffExtensionFactory {

	/**
	 * The predicate to hide difference elements.
	 */
	private static final UMLPredicate<Setting> COVERED_BY_PREDICATE = new UMLPredicate<Setting>() {
		public boolean apply(Setting input) {
			return ((ReferenceChange)input.getEObject()).getReference() == UMLPackage.Literals.LIFELINE__COVERED_BY;
		}
	};

	/**
	 * Constructor.
	 * 
	 * @param engine
	 *            The UML2 difference engine.
	 */
	public UMLMessageChangeLeftTargetFactory(UML2DiffEngine engine) {
		super(engine);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.uml2.diff.internal.extension.IDiffExtensionFactory#handles(org.eclipse.emf.compare.diff.metamodel.DiffElement)
	 */
	public boolean handles(DiffElement input) {
		return input instanceof ModelElementChangeLeftTarget
				&& ((ModelElementChangeLeftTarget)input).getLeftElement() instanceof Message;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.uml2.diff.internal.extension.IDiffExtensionFactory#create(org.eclipse.emf.compare.diff.metamodel.DiffElement,
	 *      org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer)
	 */
	public AbstractDiffExtension create(DiffElement input, EcoreUtil.CrossReferencer crossReferencer) {
		final ModelElementChangeLeftTarget changeLeftTarget = (ModelElementChangeLeftTarget)input;
		final Message message = (Message)changeLeftTarget.getLeftElement();

		final UMLMessageChangeLeftTarget ret = UML2DiffFactory.eINSTANCE.createUMLMessageChangeLeftTarget();

		final MessageEnd receiveEvent = message.getReceiveEvent();
		if (receiveEvent != null) {
			hideEvent(receiveEvent, ret, crossReferencer);
		}

		final MessageEnd sendEvent = message.getSendEvent();
		if (sendEvent != null) {
			hideEvent(sendEvent, ret, crossReferencer);
		}

		ret.getHideElements().add(changeLeftTarget);
		ret.getRequires().add(changeLeftTarget);

		ret.setRemote(changeLeftTarget.isRemote());
		ret.setRightParent(changeLeftTarget.getRightParent());
		ret.setLeftElement(changeLeftTarget.getLeftElement());

		return ret;
	}

	/**
	 * Hide events.
	 * 
	 * @param messageEnd
	 *            {@link MessageEnd}
	 * @param hiddingExtension
	 *            {@link AbstractDiffExtension}
	 * @param crossReferencer
	 *            The cross referencer.
	 */
	private void hideEvent(MessageEnd messageEnd, AbstractDiffExtension hiddingExtension,
			EcoreUtil.CrossReferencer crossReferencer) {
		hideCrossReferences(messageEnd, DiffPackage.Literals.MODEL_ELEMENT_CHANGE_LEFT_TARGET__LEFT_ELEMENT,
				hiddingExtension, crossReferencer);
		hideCrossReferences(messageEnd, DiffPackage.Literals.REFERENCE_CHANGE_LEFT_TARGET__LEFT_TARGET,
				hiddingExtension, COVERED_BY_PREDICATE, crossReferencer);
	}

}
