package ua.mibal.bot.model;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public enum Method {
    SEND_MESSAGE("sendMessage?chat_id={chat_id}&text={text}"),
    SEND_ANIMATION("sendAnimation?chat_id={chat_id}&animation={animation}");

    private final String methodTemplate;

    Method(String methodTemplate) {
        this.methodTemplate = methodTemplate;
    }

    public String getUrlBy(String urlBase) {
        return urlBase + methodTemplate;
    }
}
