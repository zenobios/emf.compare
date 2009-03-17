/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.emf.compare.epatch;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Epatch</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.compare.epatch.Epatch#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.emf.compare.epatch.Epatch#getImports <em>Imports</em>}</li>
 * <li>{@link org.eclipse.emf.compare.epatch.Epatch#getResources <em>Resources</em>}</li>
 * <li>{@link org.eclipse.emf.compare.epatch.Epatch#getObjects <em>Objects</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.compare.epatch.EpatchPackage#getEpatch()
 * @model
 * @generated
 */
public interface Epatch extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.compare.epatch.EpatchPackage#getEpatch_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.compare.epatch.Epatch#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.compare.epatch.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see org.eclipse.emf.compare.epatch.EpatchPackage#getEpatch_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Import> getImports();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.compare.epatch.NamedResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.eclipse.emf.compare.epatch.EpatchPackage#getEpatch_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<NamedResource> getResources();

	/**
	 * Returns the value of the '<em><b>Objects</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.compare.epatch.ObjectRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objects</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objects</em>' containment reference list.
	 * @see org.eclipse.emf.compare.epatch.EpatchPackage#getEpatch_Objects()
	 * @model containment="true"
	 * @generated
	 */
	EList<ObjectRef> getObjects();

} // Epatch