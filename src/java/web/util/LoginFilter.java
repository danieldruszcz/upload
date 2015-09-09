package web.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {

    public void destroy() {
   // TODO Auto-generated method stub 
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        UsuarioLogado user = null;
        HttpSession sess = ((HttpServletRequest) request).getSession(false);
        if (sess != null) {
            user = (UsuarioLogado) sess.getAttribute("usuarioLogadoS");
        }
        if (user == null) {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath + "/faces/login.xhtml");
        } else {
//           if(user.getSenha() != null){
            chain.doFilter(request, response);
//            }else{
//             String contextPath = ((HttpServletRequest) request).getContextPath();
//            ((HttpServletResponse) response).sendRedirect(contextPath + "/faces/login.xhtml");  
//            }
        }
    }

    public void init(FilterConfig arg0) throws ServletException { 
     // TODO Auto-generated method stub 
    }
}

