angular.module('simpleTests').controller('ProjetosController', function ($scope, $location, ProjetosService){
	
	$scope.projeto = null;
	$scope.projetos = [];
	$scope.exibeFormulario = false;
	
	
	$scope.exibirFormulario = function(projeto) {
		$scope.exibeFormulario = true;
		$scope.projeto = angular.copy(projeto);
	};
	
	$scope.escondeFormulario = function() {
		$scope.exibeFormulario = false;
	};
	
	$scope.salvarProjeto = function(projeto) {
		
		if(projeto.id) {
			ProjetosService.alterar(projeto).success(function(data) {
				if(data.sucesso) {
					$scope.projeto = {};
					$scope.escondeFormulario();
					carregarProjetos();
				}
			});
		} else {
			ProjetosService.incluir(projeto).success(function(data) {
				if(data.sucesso) {
					$scope.projeto = {};
					$location.path('#/projetos');
				}
			});
		}
		
		
	};
	
	$scope.excluirProjeto = function(projeto) {
		ProjetosService.excluir(projeto).success(function(data) {
			if(data.sucesso) {
				carregarProjetos();
			}
		}).error(function(data) {
			console.log('error')
			$scope.mensagemErro = data.mensagem;
		});
	}
	
	var carregarProjetos = function() {
		ProjetosService.getProjetos().success(function(data) {
			$scope.projetos = data.dados;
		})
	};
	
	carregarProjetos();
	
	
});