(function () {
    'use strict'

    angular.module('app')
        .controller('FornecedorFormController', FornecedorFormController);

    FornecedorFormController.$inject = ['FornecedorService', '$state', '$stateParams', 'DialogBuilder'];

    function FornecedorFormController(FornecedorService, $state, $stateParams, DialogBuilder) {

        var vm = this;
        vm.registro = {};
        vm.error = {};
        vm.titulo = 'Novo Fornecedor';

        vm.salvar = salvar;

        if ($stateParams.id) {
            FornecedorService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.titulo = 'Editando Fornecedor';
                });
        }

        function salvar() {
            if (!vm.registro.id) {
                FornecedorService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro inserido com sucesso!');
                        $state.go("fornecedoresList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                FornecedorService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro alterado com sucesso!');
                        $state.go("fornecedoresList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }
    }
})();