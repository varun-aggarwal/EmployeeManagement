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
     /* var fd = new FormData();
	   fd.append('name', $scope.name);
	   fd.append('role', $scope.role);
	   fd.append('bankAccountNumber', $scope.bankAccountNumber);
	   fd.append('emptype', emptype.value);
*/
      var tmpurl=currURL + "empManagement/employee/create?name="+$scope.name+"&role="+$scope.role+"&bankAccountNumber="+$scope.bankAccountNumber+"&emptype="+emptype.value;
	 $http.post(tmpurl,{

 headers: {
   'Content-Type': 'application/x-www-form-urlencoded'
 },
 transformRequest: angular.identity
}).success(function(response){
	$scope.result=JSON.parse(JSON.stringify(response));
	//$scope.result=JSON.stringify(response);
	$scope.flagresult=true;
	
}).error(function(response,status)
{
	if(status==0)
		$scope.error="Server cannot be reached.";
}
);
		;
      
      };
      $scope.greaterThan = function(prop, val){
    return function(item){
      return item[prop] > val;
    }
};

$scope.checkEmployee = function()
	{
	var empCheckurl=currURL + "empManagement/employee/checkemployee?empID="+employeeStatus.value;
	 $http.post(empCheckurl,{

		 headers: {
		   'Content-Type': 'application/x-www-form-urlencoded'
		 },
		 transformRequest: angular.identity
		}).success(function(response){
			$scope.isemployee=response;
			$scope.chkEmpType=true;
		}).error(function(response,status)
		{
			if(status==0)
				$scope.error="Server cannot be reached.";
		}
		);
	};
	
	$scope.genrateEmployeeSalary = function()
	{
	var genEmpSalurl=currURL + "empManagement/employee/genSalary?empID="+genSalDropDown.value;
	 $http.post(genEmpSalurl,{

		 headers: {
		   'Content-Type': 'application/x-www-form-urlencoded'
		 },
		 transformRequest: angular.identity
		}).success(function(response){
			$scope.employeeSalary=response;
			$scope.isSalGenerated=true;
		}).error(function(response,status)
		{
			if(status==0)
				$scope.error="Server cannot be reached.";
		}
		);
	}
 

}
