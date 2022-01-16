###Case classes
create case class Song with title, artist and track attributes

    case class Song(title:String,artist:String,track:Int)

create case class object 

    val stay=Song("Stay","Inna",4)

get title from the object
    
    stay.title

try to mutate the title value 
    
    stay.title="Me Gusta"
    this fails

compare 2 case classes 
    
    val crybaby=Song("Cry Baby","Melanie Martinez",7)
    val cry_baby=Song("Cry Baby","Melanie Martinez",7)
    crybaby==cry_baby // true   

create new object using shallow copy 
    
    val chandelier1=crybaby.copy()
    val chandelier2=crybaby.copy(title=crybaby.artist,artist="Sia")
    // Song(Cry Baby,Sia,7)

###Enumeration

create enumerater with for days in a week

    object WeekDay extends Enumeration {
    type WeekDay = Value
    val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
    }

implement a function isWorkingDay 

    def isWorkingDay(d: WeekDay) = ! (d == Sat || d == Sun)

get the working days for the enumerater 

    WeekDay.values filter isWorkingDay

overriding identifier and name
    
    val Mon = Value(1, "Monday")
    val Tue = Value(2, "Tuesday")
    val Wed = Value(3, "Wednesday")
    val Thu = Value(4, "Thursday")
    val Fri = Value(5, "Friday")
    val Sat = Value(6, "Saturday")
    val Sun = Value(7, "Sunday")


###Expression

write simple expression
    
    5 + 10

write statement expression
    
    val

write expression block 

    val square = {
        val x = 3
        x*x
    } // square = 9

write if-else expression 

    val flag = if(15%2==0) "even" else "odd"

write match expression 

    15%2 match {
        case 0 => "even"
        case 1 => "odd"
    }

write for and while loop statements 

write expression using loop
