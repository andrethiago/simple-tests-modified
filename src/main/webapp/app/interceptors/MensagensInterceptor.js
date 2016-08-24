angular.module('simpleTests').factory('MensagensInterceptor', function($q, $rootScope){
	return {
		request: function(config) {
			return config;
		},
		response: function (response) {
			
			console.log('mensagemSucesso: ' + $rootScope.mensagemSucesso)
			
			if(response.data.mensagem) {
				if(response.data.sucesso) {
					console.log('colocando mensagemSucesso ' + response.data.mensagem)
					$rootScope.mensagemSucesso = response.data.mensagem;  
				} else {
					$rootScope.mensagemAviso = response.data.mensagem;
				}
			}
			
			
			return response;
		},
		responseError: function (rejection) {
			console.log(rejection);
			return $q.reject(rejection);
		}
	};
});