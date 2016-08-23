angular.module('simpleTests').factory('UsuariosService', function($http) {
	return {
		getUsuarios : function() {
			return $http.get('/simpletests/usuarios');
		},
		
		incluir : function(usuario) {
			return $http.put('/simpletests/usuarios', usuario);
		},
		
		alterar : function(usuario) {
			return $http.post('/simpletests/usuarios', usuario);
		},
		
		excluir : function(usuario) {
			return $http.delete('/simpletests/usuarios/' + usuario.id);
		}
	
	
	}
});