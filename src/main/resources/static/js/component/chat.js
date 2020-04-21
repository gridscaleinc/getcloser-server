Vue.component('talk-item', {
  props: ['id','talk'],
  template: '<li>{{ talk.text }}</li>'
})