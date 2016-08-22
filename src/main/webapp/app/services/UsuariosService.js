angular.module('simpleTests').factory('UsuariosService', function($http) {
	return {
		getUsuarios : function() {
			return $http.get('/usuarios');
		},
		
		incluir : function(usuario) {
			return $http.put('/usuarios', usuario);
		},
		
		alterar : function(usuario) {
			return $http.post('/usuarios', usuario);
		},
		
		excluir : function(usuario) {
			return $http.delete('/usuarios/' + usuario.id);
		}
	
	
	}
});