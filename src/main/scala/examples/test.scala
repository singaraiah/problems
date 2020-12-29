package examples

import scala.collection.mutable

object  test extends App {
  val arr = Array(1,231,313,31,321,10)


//  a[w], a[x], a[y], a[z] such that w > x > y > z and a[w] - a[x] + a[y] - a[z] is maximum

//  emp
//  id,name, deptid, sal,
//  select name, deptid (select name, deptid, row_number() over(partition by deptid order by sal desc) as rn
//  from emp) a where rn = 2

//  uid, date, prodid
//  select uid, year,wk, sum(wkno) as wksum
//  (select uid, year(date) as yr, weekofyear(date) as wk,
//    case when weekday(date) = 0 then pow(2,0)
//     when weekday(date) = 1 then pow(2,1)
//     when weekday(date) = 2 then pow(2,2)
//     when weekday(date) = 3 then pow(2,3)
//     when weekday(date) = 4 then pow(2,4)
//     when weekday(date) = 5 then pow(2,5)
//     when weekday(date) = 6 then pow(2,6) as wkno
//  from table1 ) a
//  group by year, wk
//  having sum(wkno) in ( (pow(2,0) + pow(2,1) + pow(2,2)), (pow(2,3) + pow(2,1) + pow(2,2)), (pow(2,4) + pow(2,3) + pow(2,2)), (pow(2,4) + pow(2,3) + pow(2,5)),
//    (pow(2,4) + pow(2,6) + pow(2,5)), (pow(2,7) + pow(2,6) + pow(2,5)) )

}



