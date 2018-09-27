var myapp = new Vue({
  el: '#myapp',
  data: {
	  sensors: null,
	  gridColumns: ['id', 'name', "te", "hu"]
  },
  created: function () {
	  this.fetch();
  },
  methods: {
    fetch: function () {
      this.$http.get('/homewizard/rest/temperatur/list').then(response => {
        this.sensors = response.body
      }, response => {
    	  console.log(response.status);
      })
    }
  }
})
