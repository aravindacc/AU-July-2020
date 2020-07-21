function myFunction() {
    var x = document.getElementById("myText").value;
    var xarr = x.split(',');
    sort_arr = xarr.sort();
    document.getElementById("demo").innerHTML = 'Sorted array: ' + sort_arr;
    
    var filter_arr = sort_arr.filter(function (ar) {
      return ar > 10;
     });
    document.getElementById("demo1").innerHTML = 'Filter(>10): ' + filter_arr;
    
    var add1_arr = []
    foreach_arr = filter_arr.forEach(function (ar) {
      ar1 = +ar + +1;
      add1_arr.push(ar1);
     });
    document.getElementById("demo2").innerHTML = 'Add 1: ' + add1_arr;
  
    var slice_arr = add1_arr.slice(1, 4);
    document.getElementById("demo3").innerHTML = 'Array(1-4): ' + slice_arr;
  }