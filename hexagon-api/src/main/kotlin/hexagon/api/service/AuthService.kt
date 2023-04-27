package hexagon.api.service

interface AuthService : BaseService {
  fun login(email: String, password: String)
}
