package test;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController("/test")
public class MyController {

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MyModel> getModels() {
        List<MyModel> models = new LinkedList<>();
        for (int i = 0; i < 500; i++) {
            models.add(MyModel.builder().name("" + i).build());
        }
        models.add(MyModel.builder().name("fail").throwException(true).build());
        return models;
    }

}
