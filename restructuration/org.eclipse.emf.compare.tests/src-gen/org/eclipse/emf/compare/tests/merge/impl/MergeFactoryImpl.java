/**
 * Copyright (c) 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.eclipse.emf.compare.tests.merge.impl;

import org.eclipse.emf.compare.tests.merge.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MergeFactoryImpl extends EFactoryImpl implements MergeFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011, 2012 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation"; //$NON-NLS-1$

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MergeFactory init() {
		try {
			MergeFactory theMergeFactory = (MergeFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/emf/compare/tests/merge"); //$NON-NLS-1$ 
			if (theMergeFactory != null) {
				return theMergeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MergeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MergePackage.NODE: return createNode();
			case MergePackage.NODE_MULTIPLE_CONTAINMENT: return createNodeMultipleContainment();
			case MergePackage.NODE_SINGLE_VALUE_CONTAINMENT: return createNodeSingleValueContainment();
			case MergePackage.NODE_SINGLE_VALUE_ATTRIBUTE: return createNodeSingleValueAttribute();
			case MergePackage.NODE_MULTI_VALUED_ATTRIBUTE: return createNodeMultiValuedAttribute();
			case MergePackage.NODE_SINGLE_VALUE_REFERENCE: return createNodeSingleValueReference();
			case MergePackage.NODE_MULTI_VALUE_REFERENCE: return createNodeMultiValueReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeMultipleContainment createNodeMultipleContainment() {
		NodeMultipleContainmentImpl nodeMultipleContainment = new NodeMultipleContainmentImpl();
		return nodeMultipleContainment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeSingleValueContainment createNodeSingleValueContainment() {
		NodeSingleValueContainmentImpl nodeSingleValueContainment = new NodeSingleValueContainmentImpl();
		return nodeSingleValueContainment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeSingleValueAttribute createNodeSingleValueAttribute() {
		NodeSingleValueAttributeImpl nodeSingleValueAttribute = new NodeSingleValueAttributeImpl();
		return nodeSingleValueAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeMultiValuedAttribute createNodeMultiValuedAttribute() {
		NodeMultiValuedAttributeImpl nodeMultiValuedAttribute = new NodeMultiValuedAttributeImpl();
		return nodeMultiValuedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeSingleValueReference createNodeSingleValueReference() {
		NodeSingleValueReferenceImpl nodeSingleValueReference = new NodeSingleValueReferenceImpl();
		return nodeSingleValueReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeMultiValueReference createNodeMultiValueReference() {
		NodeMultiValueReferenceImpl nodeMultiValueReference = new NodeMultiValueReferenceImpl();
		return nodeMultiValueReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergePackage getMergePackage() {
		return (MergePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MergePackage getPackage() {
		return MergePackage.eINSTANCE;
	}

} //MergeFactoryImpl
