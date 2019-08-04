(function() {
  "use strict";

  const URI = "http://localhost:8080/api/produtos";

  angular.module("app").service("ProdutoService", ProdutoService);

  ProdutoService.$inject = ["$http"];

  function ProdutoService($http) {
    function findAllOver() {
      return $http.get(`${URI}/all?order=descricao`).then(function(response) {
        return response.data;
      });
    }

    function findAll(filtro, page) {
      return $http
        .get(
          `${URI}?page=${page.number}&size=${
            page.size
          }&filterField=descricao&filterValue=${filtro}`
        )
        .then(function(response) {
          return {
            registros: response.data,
            total: response.headers("X-Total-Lenght"),
            pageSize: response.headers("X-Page-Size"),
            pages: _calcPage(
              response.headers("X-Total-Lenght"),
              response.headers("X-Page-Size")
            ),
            currentPage: response.headers("X-Current-Page")
          };
        });
    }

    function _calcPage(totalRegistros, tamanhoPagina) {
      var pages = [];
      var num = totalRegistros / tamanhoPagina;
      var actual = 1;

      while (num > 0) {
        pages.push(actual++);
        num -= 1;
      }

      return pages;
    }

    function findById(id) {
      return $http.get(`${URI}/${id}`).then(function(response) {
        return response.data;
      });
    }

    function insert(registro) {
      return $http.post(URI, registro).then(function(response) {
        return response.data;
      });
    }

    function update(registro) {
      return $http
        .put(`${URI}/${registro.id}`, registro)
        .then(function(response) {
          return response.data;
        });
    }

    function remove(id) {
      return $http.delete(`${URI}/${id}`).then(function(response) {
        return response.data;
      });
    }

    return {
      findAllOver: findAllOver,
      findAll: findAll,
      findById: findById,
      insert: insert,
      update: update,
      remove: remove
    };
  }
})();
