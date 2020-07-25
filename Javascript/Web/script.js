
function task1(){
	let expression = window.prompt("Enter your string: ");
	return ["your Regex:-"+regex(expression)];
}

function regex(string){
	var reg = /^[hdn]ot.*[hdn]o*t$/;
	return reg.test(string);
}
function task3(){
	let array1 = window.prompt("Enter your Element(space separated): ");
	return array_function(array1);


}
function array_function(array1){
	let Array = array1.split(" ")
	let Filter_array = Array.filter((item)=>{return item>10})
	let Add_one_array = Filter_array.map((item)=>{return Number(Number(item)+1)})
	let Sorted_array = Add_one_array.sort(sort1)
	let First_Four = four_element(Sorted_array)
	return ["Input_array:-"+Array,"Filter_array:-"+Filter_array,"Add_one_array:-" +Add_one_array, "Sorted_array:-"+Sorted_array,"First_Four_element:-"+First_Four];

}
function sort1(a, b) {
	return a > b ? 1 : b > a ? -1 : 0;
}
function four_element(array){
	let first_four_element = array.slice(0,4)
	if(first_four_element.length<4)
	{
		while(first_four_element.length<4){
			first_four_element.push("null")
		}	
	}
	return first_four_element
}

