package parser;

import lombok.SneakyThrows;
import org.junit.Test;
import org.prophetech.hyperone.vegaops.engine.core.CloudTemplateFactory;
import org.prophetech.hyperone.vegaops.engine.model.CloudAction;
import org.prophetech.hyperone.vegaops.engine.model.CloudTemplate;
import org.prophetech.hyperone.vegaops.engine.parser.ActionParser;

import java.util.HashMap;
import java.util.Map;

public class TestImagesParser {
    @SneakyThrows
    private CloudTemplate getCloudTemplate() {
        CloudTemplate cloudTemplate = CloudTemplateFactory.getTemplate("ctyun","1.0", "image");
        cloudTemplate.setComponentId("1234567890");
        Map input = new HashMap();
        input.put("accessKey", "xxxxx");
        input.put("secret", "xxxxx");
        input.put("regionId", "cn-gzT");
        cloudTemplate.inputVars(input);
        return cloudTemplate;
    }

    @Test
    @SneakyThrows
    public void parseGetImagesList() {
        CloudTemplate cloudTemplate = getCloudTemplate();
        Map input = new HashMap();
        input.put("regionId", "cn-gzT");
        input.put("imageType","gold");
        cloudTemplate.getVariables().putAll(input);
        CloudAction list = cloudTemplate.getCloudAction("list");
        ActionParser.parse(list);
    }
}