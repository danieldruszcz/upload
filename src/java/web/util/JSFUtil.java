package web.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class JSFUtil {

	private JSFUtil(){};
	
	public static FacesContext getCurrentInstance() {
		return FacesContext.getCurrentInstance();
	}

	public static ExternalContext getExternalContext() {
		return getCurrentInstance().getExternalContext();
	}

	public static String getRequestParameter(String parameterName) {
		Map<String, String> paramMap = getExternalContext()
				.getRequestParameterMap();
		return (String) paramMap.get(parameterName);
	}

	public static Object getRequestAttribute(String attributeName) {
		Map<String, Object> attrMap = getExternalContext().getRequestMap();
		return attrMap.get(attributeName);
	}

	public static Object getSessionAttribute(String attributeName) {
		Map<String, Object> attrMap = getExternalContext().getSessionMap();
		return attrMap.get(attributeName);
	}

	public static <T> T getValueExpression(String expression, Class<T> t) {
		return (T) getCurrentInstance().getApplication().evaluateExpressionGet(
				getCurrentInstance(), expression, t);
	}

	public static void setHttpRequestAttribute(String attributeName,
			Object attribute) {
		HttpServletRequest request = (HttpServletRequest) getExternalContext()
				.getRequest();
		request.setAttribute(attributeName, attribute);
	}

	public static void setHttpSessionAttribute(String attributeName,
			Object attribute) {
		HttpSession httpSession = (HttpSession) getExternalContext()
				.getSession(true);
		httpSession.setAttribute(attributeName, attribute);
	}

	public static Object getApplicationAttribute(String attributeName) {
		Map<String, Object> reqAttrMap = getExternalContext()
				.getApplicationMap();
		return reqAttrMap.get(attributeName);
	}

	public static void addGlobalMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(message);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static void addInfoMessage(String message) {
		String messageRetorno = Geral.mensagemComHora(message);
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO, messageRetorno, messageRetorno);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static void addInfoWarning(String message) {
		String messageRetorno = Geral.mensagemComHora(message);
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_WARN, messageRetorno, messageRetorno);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static void addErrorMessage(String message) {
		String messageRetorno = Geral.mensagemComHora(message);
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_ERROR, messageRetorno, messageRetorno);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}


	
}
