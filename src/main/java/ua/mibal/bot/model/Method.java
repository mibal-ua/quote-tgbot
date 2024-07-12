package ua.mibal.bot.model;

import lombok.Getter;

import java.util.Map;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Getter
public enum Method {
    SEND_MESSAGE("sendMessage",  "chat_id", "text");
    
    private final String methodName;
    private final String[] requiredParams;

    Method(String methodName, String... requiredParams) {
        this.methodName = methodName;
        this.requiredParams = requiredParams;
    }
    
    public void validateParams(Map<String, Object> params) {
        for (String requiredParam : requiredParams) {
            if (!params.containsKey(requiredParam)) {
                throw new IllegalArgumentException("Required param " + requiredParam + " is missing");
            }
        }
    }
}
