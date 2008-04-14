/**
 * <copyright>
 * </copyright>
 *
 * $Id: BookVersion.java,v 1.1 2008/04/11 14:56:48 cbrun Exp $
 */
package org.eclipse.emf.compare.examples.addressbook.addressbook;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.compare.examples.addressbook.addressbook.BookVersion#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.emf.compare.examples.addressbook.addressbook.BookVersion#getBook <em>Book</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.compare.examples.addressbook.addressbook.AddressbookPackage#getBookVersion()
 * @model
 * @generated
 */
public interface BookVersion extends EObject {
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(int)
     * @see org.eclipse.emf.compare.examples.addressbook.addressbook.AddressbookPackage#getBookVersion_Id()
     * @model id="true" required="true"
     * @generated
     */
    int getId();

    /**
     * Sets the value of the '{@link org.eclipse.emf.compare.examples.addressbook.addressbook.BookVersion#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(int value);

    /**
     * Returns the value of the '<em><b>Book</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Book</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Book</em>' containment reference.
     * @see #setBook(AddressBook)
     * @see org.eclipse.emf.compare.examples.addressbook.addressbook.AddressbookPackage#getBookVersion_Book()
     * @model containment="true" required="true"
     * @generated
     */
    AddressBook getBook();

    /**
     * Sets the value of the '{@link org.eclipse.emf.compare.examples.addressbook.addressbook.BookVersion#getBook <em>Book</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Book</em>' containment reference.
     * @see #getBook()
     * @generated
     */
    void setBook(AddressBook value);

} // BookVersion