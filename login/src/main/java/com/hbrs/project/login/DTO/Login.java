public class Login {
     
     
        private int id;
       
	private String passwordHash;
   
        private Account account;
         
  
        public Login() {
              
         }
 
 
        public String getAccountName() {
            return this.account.getName();
        }
        public String getPasswordHash() {
            return this.account.getPasswordHash();
        }
         
        public String getSalt() {
            return this.account.getSalt();
        }
 
        public int getId() {
            return id;
        }
 
 
 
 
        public void setId(int id) {
            this.id = id;
        }
 
 
 
 
        public Account getAccount() {
            return account;
        }
 
 
 
 
        public void setAccount(Account account) {
            this.account = account;
        }
         
         
 
}