# City Green

It's an NGO, to provide plants according to your free time,
by using **City Green** can tell us about your voluntary time to do for Plantation.

# Requirements
1.   Volunteer Sign-Up page.
2.  Volunteer Sign-In page.
3. Admin Sign-In page.
4.  Planting followup form.

# Use Cases

 ## I.Volunteer Sign-Up
 
 ### 1.Brief Description
      This Use Case describes how a Volunteer Sign-Up into the City Green form.
      
 ### 2.Flow Of Events
      The Use Case begins when the Volunteer types her/his First name, Second name, User Id, email, 
      location, gender and Password on the Sign-Up form.
      
   #### 2.1 Basic Flow - SignUP
      The System receives the Volunteer Input fields and takes his/her details into DataBase, and 
      takes Volunteer in to Login Page.
      
   #### 2.2 Alternative Flow - SignUP
      User Already Exist. 
      If the User ID is alreaady exists in the Basic flow Signup, the system shows User already exist 
      try another UserID/MailID/Phonenumber.
      
  ## II.Volunteer Sign-In
 
 ### 1.Brief Description
      This Use Case describes how a Volunteer Sign-In into the City Green Application.
      
 ### 2.Flow Of Events
      The Use Case begins when the Volunteer types her/his Userid/mail/phonenumber and Password      
      on the Sign-In form.
      
   #### 2.1 Basic Flow - SignIn
      The System validates the Volunteer's user_id and password and logs him/her into the Application and 
      takes Volunteer in to Planting details form.
      
   #### 2.2 Alternative Flow - SignIn
      Invalid Username / Password. 
      If the Userid/mail/phonenumber and Password is incorrect in the Basic flow Signin, the system shows Invalid 
      Credentials and takes him/her into Login page again.
      
 ### 3. Special Requirements
     There are no special requirements associated with this Use Case.
 ### 4. Pre Conditions
     There are no pre conditions associated with this Use Case.
 ### 5. Post Conditions
     There are no post conditions associated with this Use Case.
     
## III.Admin Sign-In
 
 ### 1.Brief Description
      This Use Case describes how an Admin Sign-In into the City Green Application.
      
 ### 2.Flow Of Events
      The Use Case begins when the Admin types her/his Userid/mail/phonenumber and Password
      
   #### 2.1 Basic Flow - SignIn
      The System receives the Admin Input fields and takes his/her details into Configuration, and 
      takes Admin in to Planting Slot Page.
      
   #### 2.2 Alternative Flow - SignIn
      Inavalid Adminid / Password. 
      If the Adminid/mail/phonenumber and Password is incorrect in the Basic flow SignIn, the system shows Invalid 
      Credentials and takes him/her into Admin Login page again.
 ### 3. Special Requirements
     There are no special requirements associated with this Use Case.
 ### 4. Pre Conditions
     There are no pre conditions associated with this Use Case.
 ### 5. Post Conditions
     There are no post conditions associated with this Use Case.

# Design

# Table
 ## Users Table - Structure

| name | mail     | contact_number    | location | gender    | password |
|-------| --------|---------|-------| --------|---------|
| samchay   | char.sam@gmail.com  | 9999999999   | Indiranagar    | Male  | user@123   | 
| damon   | crazy@gmail.com  | 8888888888   | Whitefield    | Male  | test@123   | 

## Planting Slot Table

| planting_area_details | no_of_participants    | no_of_plants_req | planting_date    | planting_time | notes |
| --------|---------|-------| --------|---------|----------|
| Near Health&Glow shop - Opposite to Woodland show room, Indiranagar-1  | 6   | 18    | 12/05/2019  | 8:00 AM   | nothing |
| Near Metro station - opp to Baliji Temple, Indiranagar-2   | 9   | 25    | 15/05/2019  | 07:30 AM   | no comments |

# Test Cases
