
package services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetBirthdayMembers_QNAME = new QName("http://services/", "getBirthdayMembers");
    private final static QName _GetBirthdayMembersResponse_QNAME = new QName("http://services/", "getBirthdayMembersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBirthdayMembersResponse }
     * 
     */
    public GetBirthdayMembersResponse createGetBirthdayMembersResponse() {
        return new GetBirthdayMembersResponse();
    }

    /**
     * Create an instance of {@link GetBirthdayMembers }
     * 
     */
    public GetBirthdayMembers createGetBirthdayMembers() {
        return new GetBirthdayMembers();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBirthdayMembers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getBirthdayMembers")
    public JAXBElement<GetBirthdayMembers> createGetBirthdayMembers(GetBirthdayMembers value) {
        return new JAXBElement<GetBirthdayMembers>(_GetBirthdayMembers_QNAME, GetBirthdayMembers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBirthdayMembersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getBirthdayMembersResponse")
    public JAXBElement<GetBirthdayMembersResponse> createGetBirthdayMembersResponse(GetBirthdayMembersResponse value) {
        return new JAXBElement<GetBirthdayMembersResponse>(_GetBirthdayMembersResponse_QNAME, GetBirthdayMembersResponse.class, null, value);
    }

}
