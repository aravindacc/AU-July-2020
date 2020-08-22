
var string_len;
function checkValid()
{
    string_len=document.getElementById("string").value;
    reg=/^[hdn]ot.*[hdn]o+t$/
;
    if(reg.test(string_len))
    alert("The string is acceptable");
    else
    alert("The string is not acceptable");

}

var arr_str;
function performTask()
{
    
    arr_str= document.getElementById("array").value;
    var arr = arr_str.split(",").map(function(i){
        return parseInt(i);
    });

    array_sort=arr.sort();

    var array_filter = array_sort.filter(array_sort=>array_sort>10);
    changed_array=array_filter.map(x=>x+1)

    var ans=changed_array.slice(1,5);
    alert("The sorted array is: "+ array_sort +" The Filtered Array is "+ array_filter+ " The incremented array is "+ changed_array +" The final array is " + ans);
  
}

