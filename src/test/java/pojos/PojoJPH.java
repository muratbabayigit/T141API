package pojos;

public class PojoJPH {
    /*
    {
       "title":"Ahmet",
       "body":"Merhaba",
       "userId":10,
       "id":70
       }
     */


    // 1- Tüm variable'ları private olarak oluşturduk
        private String title;
        private String body;
        private int userId;
        private int id;

    //2- Getter ve Setter metodu ayarladık

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    //3- Variable'ları parametre olarak alan bir constructor oluşturduk

    public PojoJPH(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }


    //4- Ölen default yerine yeni bir parametresiz constructor oluşturduk

    public PojoJPH() {
    }


    //5-Information için gerekirse diye toString metdounu uyguladık

    @Override
    public String toString() {
        return "pojoJPH{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
