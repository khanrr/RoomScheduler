#explanations in comments
def get_user_name(): #defines the function that will get the user's first and last name
    fn = input("Enter first name ") #user input for first name
    ln = input("Enter last name ") #user input for last name
    return(fn,ln) #returns the values stored in fn and ln

def get_password(fn,ln): #defines the function that will get the user's password and refers to the user's first and last name
    pw = input("Enter password, password should be more than 8 characters, with at least one digit, one symbol, and one uppercase ") #user input for password
    if (fn.upper() and fn.lower() and ln.upper() and ln.lower() not in pw) and (len(pw) > 8) and set('1234567890').intersection(pw) and set('!@#$%^&*()_+').intersection(pw) and not (pw.isupper()) and not (pw.islower()): #checks input password against criteria
        return(pw) #returns the password stored in pw if it passes the criteria check
    else:
        print("Did not meet password requirements, re-enter password.")
        print("Please reconfirm password.")
        get_password(fn,ln) #executes the function again

def create_username(): #defines the function to create a username
    un = fn[:2] + ln[:3] #takes the first two characters of the first name and first three characters of the last name and puts them together
    print("Hi " + fn + ", your username is " + un + ".") #greets the user and prints the username
    return(un) #returns the username stored in un

def write_file(): #defines the function to store the username and password
    print(un + ',' + pw, file=upfile) #prints the username and password to the file

upfile = open('UD.txt', 'w') #opens the file in write mode whenever the variable upfile is used
print("USERNAME,PASSWORD", file=upfile) #prints the heading to the file
fn,ln = get_user_name() #assigns the values from the function to the variables fn and ln respectively
pw = get_password(fn,ln) #assigns the value from the function to the variable pw
un = create_username() #assigns the value from the function to the variable un
write_file() #executes the function to write information into the file
upfile.close() #closes the file