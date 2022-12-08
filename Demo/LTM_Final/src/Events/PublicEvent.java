package Events;

public class PublicEvent {
    private static PublicEvent instance;
    private MainEvent mainE;
    private ChatEvent chatE;
    private ImageViewEvent imgVE;
    private LoginEvent loginE;
    private MenuLeftEvent menuLeftE;
    
    public static PublicEvent getInstance() {
        if (instance == null) {
            instance = new PublicEvent();
        }
        return instance;
    }
    
    private PublicEvent() {
        
    }
    
    public void addMainEvent(MainEvent event) {
        this.mainE = event;
    }
    
    public MainEvent getMainEvent() {
        return mainE;
    }
    
    public void addImageViewEvent(ImageViewEvent evt) {
        this.imgVE = evt;
    }
    
    public ImageViewEvent getImageViewEvent() {
        return imgVE;
    }
    
    public void addChatEvent(ChatEvent chatEvent) {
        this.chatE = chatEvent;
    }
    
    public ChatEvent getChatEvent() {
        return chatE;
    }
    
    public void addLoginEvent(LoginEvent loginEvent) {
        this.loginE = loginEvent;
    }
    
    public LoginEvent getLoginEvent() {
        return loginE;
    }
    
    public void addMenuLeftEvent(MenuLeftEvent event) {
        this.menuLeftE = event;
    }
    
    public MenuLeftEvent getMenuLeftEvent() {
        return menuLeftE;
    }
}
