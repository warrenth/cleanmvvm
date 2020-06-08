package pe.warrenth.cleanmvvm.data.repository.comon

interface Callback  {

    interface ISingle<T>  {
        fun onSingleLoaded(value : T)
    }

    interface IList<T> {
        fun onListLoaded(value : T)
    }
}