
package client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TemperaturaService", targetNamespace = "http://server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TemperaturaService {


    /**
     * 
     * @param city
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTemperature", targetNamespace = "http://server/", className = "client.GetTemperature")
    @ResponseWrapper(localName = "getTemperatureResponse", targetNamespace = "http://server/", className = "client.GetTemperatureResponse")
    @Action(input = "http://server/TemperaturaService/getTemperatureRequest", output = "http://server/TemperaturaService/getTemperatureResponse")
    public double getTemperature(
        @WebParam(name = "city", targetNamespace = "")
        String city);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllTemperature", targetNamespace = "http://server/", className = "client.GetAllTemperature")
    @ResponseWrapper(localName = "getAllTemperatureResponse", targetNamespace = "http://server/", className = "client.GetAllTemperatureResponse")
    @Action(input = "http://server/TemperaturaService/getAllTemperatureRequest", output = "http://server/TemperaturaService/getAllTemperatureResponse")
    public List<String> getAllTemperature();

}
