/**
 *  Copyright (c) 2011 Atos.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Atos - Initial API and implementation
 * 
 */
package org.eclipse.emf.compare.sysml.sysmldiff.internal.extension.profile;

import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffPackage;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeRightTarget;
import org.eclipse.emf.compare.sysml.sysmldiff.SysMLStereotypeReferenceChangeRightTarget;
import org.eclipse.emf.compare.sysml.sysmldiff.SysMLdiffFactory;
import org.eclipse.emf.compare.sysml.utils.Utils;
import org.eclipse.emf.compare.uml2.diff.UML2DiffEngine;
import org.eclipse.emf.compare.uml2.diff.internal.extension.profile.UMLStereotypeReferenceChangeRightTargetFactory;
import org.eclipse.emf.compare.uml2diff.UMLStereotypeReferenceChangeRightTarget;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Factory for SysMLStereotypeReferenceChangeRightTargetFactory.
 * 
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net">arthur.daussy@atos.net</a>"
 * @since 1.3
 */
public class SysMLStereotypeReferenceChangeRightTargetFactory extends UMLStereotypeReferenceChangeRightTargetFactory {
	/**
	 * Constructor.
	 * 
	 * @param engine
	 *            The UML2 difference engine.
	 */
	public SysMLStereotypeReferenceChangeRightTargetFactory(UML2DiffEngine engine) {
		super(engine);
	}

	@Override
	public boolean handles(DiffElement input) {
		if (input instanceof ReferenceChange) {
			final boolean isSysML = Utils.belongToSysMLModel(((ReferenceChange)input).getRightElement());
			return super.handles(input) && isSysML;
		}
		return false;
	}

	@Override
	public AbstractDiffExtension create(DiffElement input, CrossReferencer crossReferencer) {
		final ReferenceChangeRightTarget referenceChangeRightTarget = (ReferenceChangeRightTarget)input;
		final EObject leftElement = referenceChangeRightTarget.getLeftElement();
		final EObject rightElement = referenceChangeRightTarget.getRightElement();
		final EObject leftBase = UMLUtil.getBaseElement(leftElement);
		final EObject rightBase = UMLUtil.getBaseElement(rightElement);

		final SysMLStereotypeReferenceChangeRightTarget ret = SysMLdiffFactory.eINSTANCE
				.createSysMLStereotypeReferenceChangeRightTarget();

		ret.setStereotype(UMLUtil.getStereotype(rightElement));
		ret.setRemote(input.isRemote());

		ret.setReference(referenceChangeRightTarget.getReference());
		ret.setLeftElement(leftBase);
		ret.setRightElement(rightBase);
		ret.setRightTarget(referenceChangeRightTarget.getRightTarget());

		ret.getHideElements().add(input);
		ret.getRequires().add(input);

		/**
		 * To be sure to hide the corresponding UML element and not others
		 */
		final UMLPredicate<Setting> pre = new UMLPredicate<EStructuralFeature.Setting>() {

			private boolean isEquals(Object origin, Object target) {
				if (origin != null) {
					return origin.equals(target);
				} else {
					return target == null;
				}
			}

			public boolean apply(Setting input) {
				final EObject eObject = input.getEObject();
				if (eObject instanceof UMLStereotypeReferenceChangeRightTarget) {
					final UMLStereotypeReferenceChangeRightTarget diff = (UMLStereotypeReferenceChangeRightTarget)eObject;
					return isEquals(diff.getLeftElement(), ret.getLeftElement())
							&& isEquals(diff.getRightElement(), ret.getRightElement())
							&& isEquals(diff.getStereotype(), ret.getStereotype())
							&& isEquals(diff.getRightTarget(), ret.getRightTarget());

				}
				return false;
			}
		};
		/**
		 * Hide the UML contribution
		 */
		hideCrossReferences(rightBase, DiffPackage.Literals.REFERENCE_CHANGE__RIGHT_ELEMENT, ret, pre,
				crossReferencer);
		return ret;
	}

}
