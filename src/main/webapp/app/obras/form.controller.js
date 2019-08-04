(function () {
    'use strict'

    angular.module('app')
        .controller('ObrasFormController', ObrasFormController);

    ObrasFormController.$inject = [
        'ObrasService',
        '$state',
        '$stateParams',
        'DialogBuilder',
        'ClienteService'
    ];

    function ObrasFormController(ObrasService, $state, $stateParams, DialogBuilder, ClienteService) {

        var vm = this;
        vm.registro = {
            // inicio: new Date(),
            total: 0,
            etapas: []
        };
        vm.error = {};
        vm.titulo = 'Nova obra';
        
        vm.clientes = [];
        
        vm.salvar = salvar;
        
        vm.itemOriginal = null;
        vm.registroItem = {};

        vm.excluirItem = excluirItem;
        vm.editarItem = editarItem;
        vm.salvarItem = salvarItem;
        vm.novoItem = novoItem;

        ClienteService.findAllOver()
            .then(function (data) {
                vm.clientes = data;
            });

        if ($stateParams.id) {
            ObrasService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.registro.etapas = vm.registro.etapas || [];
                    vm.titulo = 'Editando obra';
                });
        }

        function salvar() {
            if (!vm.registro.id) {
                ObrasService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro incluído com sucesso!');
                        $state.go('obrasList');
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                ObrasService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro alterado com sucesso!');
                        $state.go('obrasList');
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }

        function novoItem() {
            vm.itemOriginal = null;
            vm.registroItem = {};
        }

        function editarItem(selecionado) {
            vm.itemOriginal = selecionado;
            angular.copy(selecionado, vm.registroItem);
        }

        function salvarItem() {
            var index = vm.registro.etapas.indexOf(vm.itemOriginal);
            if (index != -1) {
                vm.registro.etapas[index] = vm.registroItem;
            } else {
                vm.registro.etapas.push(vm.registroItem);
            }
            vm.itemOriginal = null;
            vm.registroItem = {};

            // calcula o total da obra
            vm.registro.total = 0;
            vm.registro.etapas.forEach(function (item) {
                vm.registro.total += item.total;
            });
        }

        function excluirItem(selecionado) {
            var index = vm.registro.etapas.indexOf(selecionado);
            vm.registro.etapas.splice(index, 1);

            // calcula o total da obra
            vm.registro.total = 0;
            vm.registro.etapas.forEach(function (item) {
                vm.registro.total += item.total;
            });
        }

    }
})();