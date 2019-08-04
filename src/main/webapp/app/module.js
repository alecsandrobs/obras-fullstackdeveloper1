(function() {
  angular.module("app", ["ui.router", "mgcrea.ngStrap"]);

  angular.module("app").config(AppConfig);

  AppConfig.$inject = ["$stateProvider"];

  function AppConfig($stateProvider) {
    $stateProvider
      .state({
        name: "app",
        url: "/",
        templateUrl: ""
      })
      .state({
        name: "clientesList",
        url: "/clientes",
        templateUrl: "/views/clientes/list.html",
        controller: "ClienteListController",
        controllerAs: "vm"
      })
      .state({
        name: "clientesNovo",
        url: "/clientes/novo",
        templateUrl: "/views/clientes/form.html",
        controller: "ClienteFormController",
        controllerAs: "vm"
      })
      .state({
        name: "clientesEditar",
        url: "/clientes/{id}",
        templateUrl: "/views/clientes/form.html",
        controller: "ClienteFormController",
        controllerAs: "vm"
      })
      .state({
        name: "fornecedoresList",
        url: "/fornecedores",
        templateUrl: "/views/fornecedores/list.html",
        controller: "FornecedorListController",
        controllerAs: "vm"
      })
      .state({
        name: "fornecedoresNovo",
        url: "/fornecedores/novo",
        templateUrl: "/views/fornecedores/form.html",
        controller: "FornecedorFormController",
        controllerAs: "vm"
      })
      .state({
        name: "fornecedoresEditar",
        url: "/fornecedores/{id}",
        templateUrl: "/views/fornecedores/form.html",
        controller: "FornecedorFormController",
        controllerAs: "vm"
      })
      .state({
        name: "produtosList",
        url: "/produtos",
        templateUrl: "/views/produtos/list.html",
        controller: "ProdutoListController",
        controllerAs: "vm"
      })
      .state({
        name: "produtosNovo",
        url: "/produtos/novo",
        templateUrl: "/views/produtos/form.html",
        controller: "ProdutoFormController",
        controllerAs: "vm"
      })
      .state({
        name: "produtosEditar",
        url: "/produtos/{id}",
        templateUrl: "/views/produtos/form.html",
        controller: "ProdutoFormController",
        controllerAs: "vm"
      })
      .state({
        name: "pedidosList",
        url: "/pedidos",
        templateUrl: "/views/pedidos/list.html",
        controller: "PedidoListController",
        controllerAs: "vm"
      })
      .state({
        name: "pedidosNovo",
        url: "/pedidos/novo",
        templateUrl: "/views/pedidos/form.html",
        controller: "PedidoFormController",
        controllerAs: "vm"
      })
      .state({
        name: "pedidosEditar",
        url: "/pedidos/{id}",
        templateUrl: "/views/pedidos/form.html",
        controller: "PedidoFormController",
        controllerAs: "vm"
      })
      .state({
        name: "pedidosFornecedorList",
        url: "/pedidos-fornecedores",
        templateUrl: "/views/pedidosFornecedores/list.html",
        controller: "PedidoFornecedorListController",
        controllerAs: "vm"
      })
      .state({
        name: "pedidosFornecedorNovo",
        url: "/pedidos-fornecedores/novo",
        templateUrl: "/views/pedidosFornecedores/form.html",
        controller: "PedidoFornecedorFormController",
        controllerAs: "vm"
      })
      .state({
        name: "pedidosFornecedorEditar",
        url: "/pedidos-fornecedores/{id}",
        templateUrl: "/views/pedidosFornecedores/form.html",
        controller: "PedidoFornecedorFormController",
        controllerAs: "vm"
      })
      .state({
        name: "obrasList",
        url: "/obras",
        templateUrl: "/views/obras/list.html",
        controller: "ObrasListController",
        controllerAs: "vm"
      })
      .state({
        name: "obrasNovo",
        url: "/obras/novo",
        templateUrl: "/views/obras/form.html",
        controller: "ObrasFormController",
        controllerAs: "vm"
      })
      .state({
        name: "obrasEditar",
        url: "/obras/{id}",
        templateUrl: "/views/obras/form.html",
        controller: "ObrasFormController",
        controllerAs: "vm"
      });
  }
})();
