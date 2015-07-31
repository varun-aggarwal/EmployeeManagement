function createEmployeeController($scope,$http,$location) {
	$scope.emptype="Internal";
	$scope.flagresult=false;
	$scope.result={};
	$scope.error="";
	$scope.chkEmpType=false;
	var currURL=$location.absUrl();
	 $scope.submit = function() 
      {
      $scope.flagerror=false;
 
      var tmpurl=currURL + "empManagement/garbageCollection/hire?noOfEmplyees="+$scope.noOfEmplyees;
	 $http.post(tmpurl,{

 headers: {
   'Content-Type': 'application/x-www-form-urlencoded'
 },
 transformRequest: angular.identity
}).success(function(response){
	//$scope.result=JSON.parse(JSON.stringify(response));
	alert(response);
	//$scope.result=JSON.stringify(response);
	$scope.checkResources();
	
}).error(function(response,status)
{
	if(status==0)
		$scope.error="Server cannot be reached.";
}
);
		;
      
      };
 	 $scope.fire = function() 
     {
     var tmpurl=currURL + "empManagement/garbageCollection/fire?noOffireEmplyees="+$scope.noOffireEmplyees;
	 $http.post(tmpurl,{

headers: {
  'Content-Type': 'application/x-www-form-urlencoded'
},
transformRequest: angular.identity
}).success(function(response){
	//$scope.result=JSON.parse(JSON.stringify(response));
	alert(response);
	//$scope.result=JSON.stringify(response);
	
	$scope.checkResources();
	
}).error(function(response,status)
{
	if(status==0)
		$scope.error="Server cannot be reached.";
}
);
		;
     
     };
 

$scope.drawChart = function(free,Busy){
	// Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Topping');
    data.addColumn('number', 'Slices');
    data.addRows([
      ['Free Resources', free],
      ['Busy Resources', Busy],
     
    ]);

    // Set chart options
    
					 var options = {
'legend':'left',
'title':'My Resources',
'is3D':true,
'width':600,
'height':500
}

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
    chart.draw(data, options);
};

$scope.checkResources = function(){

	
	var freeSpace=0;
	var busySpace=0;
	
    var checkResources=currURL + "empManagement/garbageCollection/checkResources?name=name";
     $http.post(checkResources,{

headers: {
 'Content-Type': undefined
},
transformRequest: angular.identity
}).success(function(response){
	
	//$scope.result=JSON.parse(JSON.stringify(response));
	//alert(response);
	freeSpace=response.split("~")[1];
	busySpace=response.split("~")[0];
	//$scope.result=JSON.stringify(response);
	
$scope.drawChart(parseInt(freeSpace),parseInt(busySpace));
	
	
}).error(function(response,status)
{
	if(status==0)
		$scope.error="Server cannot be reached.";
}
);
		

};
angular.element(document).ready(function()
{
	$scope.checkResources();	
}
 )
 

}
