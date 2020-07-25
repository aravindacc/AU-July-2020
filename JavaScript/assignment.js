var regexstring;
function getRegex()
{
    regexstring=document.getElementById("regex").value;
    reg=/^[hdn]ot.*[hdn]o*t$/

    //document.write(reg.test(regexstring));
    alert(reg.test(regexstring))

}


var str;
function getValue()
{
    //getting value from user
    str= document.getElementById("Enter").value;
    var n=str.length;

    //splitting the string
    var array = str.split(" ").map(function(i){
        return parseInt(i);
    });

    
    document.write(" "+array);
    document.write("<br>");

    //sorting the array;
    var sortedarray=array.sort(function(a, b){return a-b});
    document.write(sortedarray +"  ");
    document.write("<br>");

    //filtering an array
    var filterarray = sortedarray.filter(sortedarray=>sortedarray>10);
    document.write(filterarray+ " ");
    document.write("<br>");

    //adding 1 to all element in array
    for (var i = 0; i < filterarray.length; i++){
        filterarray[i] = filterarray[i] + 1;
    }
    document.write(filterarray+ " ");
    document.write("<br>");

    // array from 1 to 4
    var spliced=filterarray.splice(1,5);
    document.write(spliced+ " ");
    document.write("<br>");
        
}

