def get_user_name(): 
    fn = input("Enter first name ") 
    ln = input("Enter last name ") 
    return(fn,ln) 


def get_password(fn,ln): 
    pw = input("Enter password, password should be more than 8 characters, with at least one digit, one symbol, and one uppercase ") 
    if (fn.upper() and fn.lower() and ln.upper() and ln.lower() not in pw) and (len(pw) > 8) and set('1234567890').intersection(pw) and set('!@#$%^&*()_+').intersection(pw) and not (pw.isupper()) and not (pw.islower()): 
    else:
        print("Did not meet password requirements, re-enter password.")
        print("Please reconfirm password.")
        get_password(fn,ln) 

        
def create_username(): 
    un = fn[:2] + ln[:3] 
    print("Hi " + fn + ", your username is " + un + ".") 
    return(un) 


def write_file(): 
    print(un + ',' + pw, file=upfile) 

    
upfile = open('UD.txt', 'w') 
print("USERNAME,PASSWORD", file=upfile) 
fn,ln = get_user_name() 
pw = get_password(fn,ln) 
un = create_username() 
write_file() 
upfile.close() 
