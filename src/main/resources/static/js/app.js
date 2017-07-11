var app=angular.module("MyApp",['ngRoute']);
app.config(function($stateProvider,$urlRouterProvider){
	$stateProvider.state("entreprises",{
		url:"/entreprises", 
		templateUrl: "views/entreprises.html", 
		controller: "MyController"
	});
	$stateProvider.state("taxe",{
		url:"/taxes", 
		templateUrl: "views/taxes.html", 
		controller: "TaxeController"
	});	
});
function f1() {alert('test2');}
app.controller("TaxeController",function(){
	
})
app.controller("MyController",function($scope,$http){
	$scope.pageEntreprises=[];
	$scope.test="test1";
	$scope.motCle="";
	$scope.pageCourante=0;
	$scope.size=5;
	$scope.pages=[];
	$scope.chercher=function(){
		$http.get("http://localhost:8080/listEntreprises?motCle="+$scope.motCle+"&page="+$scope.pageCourante+"&size="+$scope.size)
		.success(function(data){
			$scope.pageEntreprises=data;
			$scope.pages=new Array(data.totalPages);
		})
		.error(function(err){
			Console.log(err);
		});
	}
	$scope.goToPage=function(p){
		$scope.pageCourante=p;
		$scope.chercher();		
	}
});