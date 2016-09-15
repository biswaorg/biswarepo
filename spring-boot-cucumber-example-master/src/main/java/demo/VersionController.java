package demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class VersionController
{
    @RequestMapping(method={RequestMethod.GET},value={"/version"})
    public String getVersion(HttpServletResponse response)
    {
        return "1.0";
    }
}
