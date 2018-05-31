import mattframpton.endclothing_mattframpton.view.BaseView

class BasePresenter<V : BaseView> {

    var view: V? = null
        private set

    val isAttached: Boolean
        get() = view != null


    fun attach(view: V) {
        this.view = view
    }

    fun detach() {
        view = null
    }
}