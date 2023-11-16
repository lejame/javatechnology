package vn.tdtu.edu.Ex1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static jakarta.servlet.RequestDispatcher.ERROR_STATUS_CODE;

@Controller
public class CustomErrorController implements ErrorController {
    private int getErrorCode(HttpServletRequest httpServletRequest) {
        Object code = httpServletRequest.getAttribute(ERROR_STATUS_CODE);
        return code == null ? 0 : (Integer)code;
    }
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(HttpServletRequest httpServletRequest, Model model) {
        String errMsg = "";
        int httpCode = getErrorCode(httpServletRequest);
        switch (httpCode) {
            case 400: {
                errMsg = "400: Bad Request";
                break;
            }
            case 401: {
                errMsg = "401: Unauthorized";
                break;
            }
            case 403: {
                errMsg = "403: Forbidden";
                break;
            }
            case 404: {
                errMsg = "404: Not Found";
                break;
            }
            case 409: {
                errMsg = "409: Conflict";
                break;
            }
            case 500: {
                errMsg = "500: Internal Server Error";
                break;
            }
            case 502: {
                errMsg = "502: Bad Gateway";
                break;
            }
            case 503: {
                errMsg = "503: Service Unavailable";
                break;
            }
            case 504: {
                errMsg = "504: Gateway Timeout";
                break;
            }
            default:
                errMsg = "Error";
        }
        model.addAttribute("errMsg", errMsg);
        return "error";
    }
}
