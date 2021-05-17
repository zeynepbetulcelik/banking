package entity;

/**
 *
 * @author zeynep
 */
public class Person {

     private String id;
     private String username;

     public Person(String id, String username, String email, String phonenumber, String gender) {
          this.id = id;
          this.username = username;
          this.email = email;
          this.phonenumber = phonenumber;
          this.gender = gender;
     }
     private String email;
     private String password;
     private String phonenumber;
     private String gender;
     private Account account;
     private Card card;
     public static Person PersonInstance;
     public static Person UserInstance;

     public String getPhonenumber() {
          return phonenumber;
     }

     public void setPhonenumber(String phonenumber) {
          this.phonenumber = phonenumber;
     }

     public String getGender() {
          return gender;
     }

     public void setGender(String gender) {
          this.gender = gender;
     }

     public Account getAccount() {
          return account;
     }

     public void setAccount(Account account) {
          this.account = account;
     }

     public Card getCard() {
          return card;
     }

     public void setCard(Card card) {
          this.card = card;
     }

     public static Person getPersonInstance() {
          return PersonInstance;
     }

     public static void setPersonInstance(Person PersonInstance) {
          Person.PersonInstance = PersonInstance;
     }

     public static Person getUserInstance() {
          return UserInstance;
     }

     public static void setUserInstance(Person UserInstance) {
          Person.UserInstance = UserInstance;
     }

     public Person(String id, String username, String email, String password) {
          this.id = id;
          this.username = username;
          this.email = email;
          this.password = password;
     }

     public Person() {
     }

     public Person(String id, String username, String email) {
          this.id = id;
          this.username = username;
          this.email = email;
     }

     public Person(String id, String username, String email, Account account) {
          this.id = id;
          this.username = username;
          this.email = email;
          this.account = account;

     }

     public Person(String id, String username, String email, Account account, Card card) {
          this.id = id;
          this.username = username;
          this.email = email;
          this.card = card;
          this.account = account;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     @Override
     public String toString() {
          return "Person{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", phonenumber=" + phonenumber + ", gender=" + gender + ", account=" + account + ", card=" + card + '}';
     }

}
