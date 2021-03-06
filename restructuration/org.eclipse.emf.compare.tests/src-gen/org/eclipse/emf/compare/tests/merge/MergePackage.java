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
package org.eclipse.emf.compare.tests.merge;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.compare.tests.merge.MergeFactory
 * @model kind="package"
 * @generated
 */
public interface MergePackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011, 2012 Obeo.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Obeo - initial API and implementation"; //$NON-NLS-1$

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "merge"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/compare/tests/merge"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "merge"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MergePackage eINSTANCE = org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.compare.tests.merge.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.compare.tests.merge.impl.NodeImpl
	 * @see org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl#getNode()
	 * @generated
	 */
	int NODE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Containment Ref1</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CONTAINMENT_REF1 = 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.compare.tests.merge.impl.NodeMultipleContainmentImpl <em>Node Multiple Containment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.compare.tests.merge.impl.NodeMultipleContainmentImpl
	 * @see org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl#getNodeMultipleContainment()
	 * @generated
	 */
	int NODE_MULTIPLE_CONTAINMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MULTIPLE_CONTAINMENT__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Containment Ref1</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MULTIPLE_CONTAINMENT__CONTAINMENT_REF1 = NODE__CONTAINMENT_REF1;

	/**
	 * The feature id for the '<em><b>Containment Ref2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MULTIPLE_CONTAINMENT__CONTAINMENT_REF2 = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Multiple Containment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MULTIPLE_CONTAINMENT_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.compare.tests.merge.impl.NodeSingleValueContainmentImpl <em>Node Single Value Containment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.compare.tests.merge.impl.NodeSingleValueContainmentImpl
	 * @see org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl#getNodeSingleValueContainment()
	 * @generated
	 */
	int NODE_SINGLE_VALUE_CONTAINMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_SINGLE_VALUE_CONTAINMENT__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Containment Ref1</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_SINGLE_VALUE_CONTAINMENT__CONTAINMENT_REF1 = NODE__CONTAINMENT_REF1;

	/**
	 * The feature id for the '<em><b>Single Value Containment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_SINGLE_VALUE_CONTAINMENT__SINGLE_VALUE_CONTAINMENT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Single Value Containment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_SINGLE_VALUE_CONTAINMENT_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.compare.tests.merge.impl.NodeSingleValueAttributeImpl <em>Node Single Value Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.compare.tests.merge.impl.NodeSingleValueAttributeImpl
	 * @see org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl#getNodeSingleValueAttribute()
	 * @generated
	 */
	int NODE_SINGLE_VALUE_ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_SINGLE_VALUE_ATTRIBUTE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Containment Ref1</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_SINGLE_VALUE_ATTRIBUTE__CONTAINMENT_REF1 = NODE__CONTAINMENT_REF1;

	/**
	 * The feature id for the '<em><b>Single Valued Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_SINGLE_VALUE_ATTRIBUTE__SINGLE_VALUED_ATTRIBUTE = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Single Value Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_SINGLE_VALUE_ATTRIBUTE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.compare.tests.merge.impl.NodeMultiValuedAttributeImpl <em>Node Multi Valued Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.compare.tests.merge.impl.NodeMultiValuedAttributeImpl
	 * @see org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl#getNodeMultiValuedAttribute()
	 * @generated
	 */
	int NODE_MULTI_VALUED_ATTRIBUTE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MULTI_VALUED_ATTRIBUTE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Containment Ref1</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MULTI_VALUED_ATTRIBUTE__CONTAINMENT_REF1 = NODE__CONTAINMENT_REF1;

	/**
	 * The feature id for the '<em><b>Multi Valued Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MULTI_VALUED_ATTRIBUTE__MULTI_VALUED_ATTRIBUTE = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Multi Valued Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MULTI_VALUED_ATTRIBUTE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.compare.tests.merge.impl.NodeSingleValueReferenceImpl <em>Node Single Value Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.compare.tests.merge.impl.NodeSingleValueReferenceImpl
	 * @see org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl#getNodeSingleValueReference()
	 * @generated
	 */
	int NODE_SINGLE_VALUE_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_SINGLE_VALUE_REFERENCE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Containment Ref1</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_SINGLE_VALUE_REFERENCE__CONTAINMENT_REF1 = NODE__CONTAINMENT_REF1;

	/**
	 * The feature id for the '<em><b>Single Valued Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_SINGLE_VALUE_REFERENCE__SINGLE_VALUED_REFERENCE = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Single Value Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_SINGLE_VALUE_REFERENCE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.compare.tests.merge.impl.NodeMultiValueReferenceImpl <em>Node Multi Value Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.compare.tests.merge.impl.NodeMultiValueReferenceImpl
	 * @see org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl#getNodeMultiValueReference()
	 * @generated
	 */
	int NODE_MULTI_VALUE_REFERENCE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MULTI_VALUE_REFERENCE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Containment Ref1</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MULTI_VALUE_REFERENCE__CONTAINMENT_REF1 = NODE__CONTAINMENT_REF1;

	/**
	 * The feature id for the '<em><b>Multi Valued Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MULTI_VALUE_REFERENCE__MULTI_VALUED_REFERENCE = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Multi Value Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MULTI_VALUE_REFERENCE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.compare.tests.merge.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.compare.tests.merge.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.compare.tests.merge.Node#getContainmentRef1 <em>Containment Ref1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Containment Ref1</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.Node#getContainmentRef1()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_ContainmentRef1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.compare.tests.merge.NodeMultipleContainment <em>Node Multiple Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Multiple Containment</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.NodeMultipleContainment
	 * @generated
	 */
	EClass getNodeMultipleContainment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.compare.tests.merge.NodeMultipleContainment#getContainmentRef2 <em>Containment Ref2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Containment Ref2</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.NodeMultipleContainment#getContainmentRef2()
	 * @see #getNodeMultipleContainment()
	 * @generated
	 */
	EReference getNodeMultipleContainment_ContainmentRef2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.compare.tests.merge.NodeSingleValueContainment <em>Node Single Value Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Single Value Containment</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.NodeSingleValueContainment
	 * @generated
	 */
	EClass getNodeSingleValueContainment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.compare.tests.merge.NodeSingleValueContainment#getSingleValueContainment <em>Single Value Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Single Value Containment</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.NodeSingleValueContainment#getSingleValueContainment()
	 * @see #getNodeSingleValueContainment()
	 * @generated
	 */
	EReference getNodeSingleValueContainment_SingleValueContainment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.compare.tests.merge.NodeSingleValueAttribute <em>Node Single Value Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Single Value Attribute</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.NodeSingleValueAttribute
	 * @generated
	 */
	EClass getNodeSingleValueAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.compare.tests.merge.NodeSingleValueAttribute#getSingleValuedAttribute <em>Single Valued Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Single Valued Attribute</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.NodeSingleValueAttribute#getSingleValuedAttribute()
	 * @see #getNodeSingleValueAttribute()
	 * @generated
	 */
	EAttribute getNodeSingleValueAttribute_SingleValuedAttribute();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.compare.tests.merge.NodeMultiValuedAttribute <em>Node Multi Valued Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Multi Valued Attribute</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.NodeMultiValuedAttribute
	 * @generated
	 */
	EClass getNodeMultiValuedAttribute();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.compare.tests.merge.NodeMultiValuedAttribute#getMultiValuedAttribute <em>Multi Valued Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Multi Valued Attribute</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.NodeMultiValuedAttribute#getMultiValuedAttribute()
	 * @see #getNodeMultiValuedAttribute()
	 * @generated
	 */
	EAttribute getNodeMultiValuedAttribute_MultiValuedAttribute();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.compare.tests.merge.NodeSingleValueReference <em>Node Single Value Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Single Value Reference</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.NodeSingleValueReference
	 * @generated
	 */
	EClass getNodeSingleValueReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.compare.tests.merge.NodeSingleValueReference#getSingleValuedReference <em>Single Valued Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Single Valued Reference</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.NodeSingleValueReference#getSingleValuedReference()
	 * @see #getNodeSingleValueReference()
	 * @generated
	 */
	EReference getNodeSingleValueReference_SingleValuedReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.compare.tests.merge.NodeMultiValueReference <em>Node Multi Value Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Multi Value Reference</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.NodeMultiValueReference
	 * @generated
	 */
	EClass getNodeMultiValueReference();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.compare.tests.merge.NodeMultiValueReference#getMultiValuedReference <em>Multi Valued Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Multi Valued Reference</em>'.
	 * @see org.eclipse.emf.compare.tests.merge.NodeMultiValueReference#getMultiValuedReference()
	 * @see #getNodeMultiValueReference()
	 * @generated
	 */
	EReference getNodeMultiValueReference_MultiValuedReference();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MergeFactory getMergeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.compare.tests.merge.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.compare.tests.merge.impl.NodeImpl
		 * @see org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

		/**
		 * The meta object literal for the '<em><b>Containment Ref1</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CONTAINMENT_REF1 = eINSTANCE.getNode_ContainmentRef1();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.compare.tests.merge.impl.NodeMultipleContainmentImpl <em>Node Multiple Containment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.compare.tests.merge.impl.NodeMultipleContainmentImpl
		 * @see org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl#getNodeMultipleContainment()
		 * @generated
		 */
		EClass NODE_MULTIPLE_CONTAINMENT = eINSTANCE.getNodeMultipleContainment();

		/**
		 * The meta object literal for the '<em><b>Containment Ref2</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_MULTIPLE_CONTAINMENT__CONTAINMENT_REF2 = eINSTANCE.getNodeMultipleContainment_ContainmentRef2();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.compare.tests.merge.impl.NodeSingleValueContainmentImpl <em>Node Single Value Containment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.compare.tests.merge.impl.NodeSingleValueContainmentImpl
		 * @see org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl#getNodeSingleValueContainment()
		 * @generated
		 */
		EClass NODE_SINGLE_VALUE_CONTAINMENT = eINSTANCE.getNodeSingleValueContainment();

		/**
		 * The meta object literal for the '<em><b>Single Value Containment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_SINGLE_VALUE_CONTAINMENT__SINGLE_VALUE_CONTAINMENT = eINSTANCE.getNodeSingleValueContainment_SingleValueContainment();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.compare.tests.merge.impl.NodeSingleValueAttributeImpl <em>Node Single Value Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.compare.tests.merge.impl.NodeSingleValueAttributeImpl
		 * @see org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl#getNodeSingleValueAttribute()
		 * @generated
		 */
		EClass NODE_SINGLE_VALUE_ATTRIBUTE = eINSTANCE.getNodeSingleValueAttribute();

		/**
		 * The meta object literal for the '<em><b>Single Valued Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_SINGLE_VALUE_ATTRIBUTE__SINGLE_VALUED_ATTRIBUTE = eINSTANCE.getNodeSingleValueAttribute_SingleValuedAttribute();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.compare.tests.merge.impl.NodeMultiValuedAttributeImpl <em>Node Multi Valued Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.compare.tests.merge.impl.NodeMultiValuedAttributeImpl
		 * @see org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl#getNodeMultiValuedAttribute()
		 * @generated
		 */
		EClass NODE_MULTI_VALUED_ATTRIBUTE = eINSTANCE.getNodeMultiValuedAttribute();

		/**
		 * The meta object literal for the '<em><b>Multi Valued Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_MULTI_VALUED_ATTRIBUTE__MULTI_VALUED_ATTRIBUTE = eINSTANCE.getNodeMultiValuedAttribute_MultiValuedAttribute();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.compare.tests.merge.impl.NodeSingleValueReferenceImpl <em>Node Single Value Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.compare.tests.merge.impl.NodeSingleValueReferenceImpl
		 * @see org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl#getNodeSingleValueReference()
		 * @generated
		 */
		EClass NODE_SINGLE_VALUE_REFERENCE = eINSTANCE.getNodeSingleValueReference();

		/**
		 * The meta object literal for the '<em><b>Single Valued Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_SINGLE_VALUE_REFERENCE__SINGLE_VALUED_REFERENCE = eINSTANCE.getNodeSingleValueReference_SingleValuedReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.compare.tests.merge.impl.NodeMultiValueReferenceImpl <em>Node Multi Value Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.compare.tests.merge.impl.NodeMultiValueReferenceImpl
		 * @see org.eclipse.emf.compare.tests.merge.impl.MergePackageImpl#getNodeMultiValueReference()
		 * @generated
		 */
		EClass NODE_MULTI_VALUE_REFERENCE = eINSTANCE.getNodeMultiValueReference();

		/**
		 * The meta object literal for the '<em><b>Multi Valued Reference</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_MULTI_VALUE_REFERENCE__MULTI_VALUED_REFERENCE = eINSTANCE.getNodeMultiValueReference_MultiValuedReference();

	}

} //MergePackage
