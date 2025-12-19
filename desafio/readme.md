
<h1 style="text-align:center">1-Arquitetura Do Software</h1>
<div style="
  background-color: #0d1117;
  color: #c9d1d9;
  padding: 20px;
  border-radius: 8px;
  overflow-x: auto;
  font-family: 'Fira Code', 'JetBrains Mono', monospace;
  font-size: 14px;
  line-height: 1.5;
  border: 1px solid #30363d;
">
<h2>Esta é uma representação da arquitetura, apenas para se ter uma visão geral de como a arquitetura e o fluxo de informaçoes vai funcionar, por isto ocultei algumas classes para que a arvore nao fique ainda mais extensa</h2>
<pre>
desafio
|
+---src
|   +---main
|   |   +---java
|   |   |   \---com
|   |   |       \---example
|   |   |           \---desafio
|   |   |               |   DesafioApplication.class
|   |   |               |
|   |   |               +---controller
|   |   |               |   +---authentication
|   |   |               |   |   +---login
|   |   |               |   |   |       LoginUserController.class
|   |   |               |   |   |
|   |   |               |   |   \---register
|   |   |               |   |           UserRegisterController.class
|   |   |               |   |
|   |   |               |   +---crud
|   |   |               |   |   +---project
|   |   |               |   |   |       ProjectCrudController.class
|   |   |               |   |   |
|   |   |               |   |   \---user
|   |   |               |   |           UserCrudController.class
|   |   |               |   |
|   |   |               |   \---password
|   |   |               |       +---recovery
|   |   |               |               PasswordRecoveryController.class
|   |   |               |
|   |   |               +---dto
|   |   |               |   +---project
|   |   |               |   |       ProjectDto.class
|   |   |               |   |
|   |   |               |   +---task
|   |   |               |   |       TaskDto.class
|   |   |               |   |
|   |   |               |   \---user
|   |   |               |           UserDto.class
|   |   |               |
|   |   |               +---entity
|   |   |               |   +---project
|   |   |               |   |       Project.class
|   |   |               |   |
|   |   |               |   +---register
|   |   |               |   |   \---password
|   |   |               |   |       +---project
|   |   |               |   |       |       RegisterPasswordProject.class
|   |   |               |   |       |
|   |   |               |   |       \---user
|   |   |               |   |               RegisterPasswordUser.class
|   |   |               |   |
|   |   |               |   +---task
|   |   |               |   |       Task.class
|   |   |               |   |
|   |   |               |   \---user
|   |   |               |           User.class
|   |   |               |
|   |   |               +---repository
|   |   |               |   +---project
|   |   |               |   |       ProjectRepository.class
|   |   |               |   |
|   |   |               |   +---register
|   |   |               |   |   \---password
|   |   |               |   |       +---project
|   |   |               |   |       |       RegisterProjectPasswordRepository.class
|   |   |               |   |       |
|   |   |               |   |       \---user
|   |   |               |   |               RegisterUserPasswordRepository.class
|   |   |               |   |
|   |   |               |   \---user
|   |   |               |           UserRepository.class
|   |   |               |
|   |   |               +---security
|   |   |               |   +---cfg
|   |   |               |   |       SecurityFilterConfiguration.class
|   |   |               |   |
|   |   |               |   +---filter
|   |   |               |   |       JwtFilter.class
|   |   |               |   |
|   |   |               |   \---token
|   |   |               |       +---generate
|   |   |               |       |   +---key
|   |   |               |       |   |       GenerateSecretKeyConverted.class
|   |   |               |       |   |
|   |   |               |       |   \---token
|   |   |               |       |       +---access
|   |   |               |       |       |       GenerateTokenAccess.class
|   |   |               |       |       |
|   |   |               |       |       \---refresh
|   |   |               |       |               GenerateTokenRefresh.class
|   |   |               |       |
|   |   |               |       +---get
|   |   |               |       |   \---email
|   |   |               |       |           GetEmailByPayload.class
|   |   |               |       |
|   |   |               |       \---validation
|   |   |               |           \---token
|   |   |               |                   TokenIsValid.class
|   |   |               |
|   |   |               +---send
|   |   |               |   \---email
|   |   |               |           SendEmail.class
|   |   |               |
|   |   |               +---service
|   |   |               |   +---authentication
|   |   |               |   |   +---implementations
|   |   |               |   |   |       CustomUserDetails.class
|   |   |               |   |   |       CustomUserDetailsService.class
|   |   |               |   |   |
|   |   |               |   |   +---login
|   |   |               |   |   |   +---token
|   |   |               |   |   |   |       GenerateTokensLoginService.class
|   |   |               |   |   |   |
|   |   |               |   |   |   \---user
|   |   |               |   |   |           LoginUserService.class
|   |   |               |   |   |
|   |   |               |   |   \---register
|   |   |               |   |       +---token
|   |   |               |   |       |       GenerateTokensRegisterService.class
|   |   |               |   |       |
|   |   |               |   |       +---user
|   |   |               |   |       |       UserRegisterService.class
|   |   |               |   |       |
|   |   |               |   |       \---validation
|   |   |               |   |               EmailAndUsernameIsUnique.class
|   |   |               |   |
|   |   |               |   +---crud
|   |   |               |   |   +---project
|   |   |               |   |   |       ProjectCrudService.class
|   |   |               |   |   |
|   |   |               |   |   \---user
|   |   |               |   |           UserCrudService.class
|   |   |               |   |
|   |   |               |   +---received
|   |   |               |   |   \---token
|   |   |               |   |       \---password
|   |   |               |   |           +---project
|   |   |               |   |           |   \---save
|   |   |               |   |           |       \---register
|   |   |               |   |           |               SaveRegisterProjectPasswordService.class
|   |   |               |   |           |
|   |   |               |   |           \---user
|   |   |               |   |               +---save
|   |   |               |   |               |   \---register
|   |   |               |   |               |           SaveRegisterUserPasswordService.class
|   |   |               |   |               |
|   |   |               |   |               \---validation
|   |   |               |   |                       ValidationEmailUserExistsInEntityInDb.class
|   |   |               |   |
|   |   |               |   \---validation
|   |   |               |       \---token
|   |   |               |           \---password
|   |   |               |               +---project
|   |   |               |               |   +---get
|   |   |               |               |   |   \---register
|   |   |               |               |   |       \---by
|   |   |               |               |   |           \---token
|   |   |               |               |   |                   GetRegisterProjectByToken.class
|   |   |               |               |   |
|   |   |               |               |   +---invalidate
|   |   |               |               |   |   \---register
|   |   |               |               |   |           InvalidateRegisterProjectAfterTokenUsed.class
|   |   |               |               |   |
|   |   |               |               |   \---reset
|   |   |               |               |       \---password
|   |   |               |               |               ResetPasswordProjectAndInvalidateTokenUsed.class
|   |   |               |               |
|   |   |               |               \---user
|   |   |               |                   +---get
|   |   |               |                   |   \---register
|   |   |               |                   |       \---by
|   |   |               |                   |           \---token
|   |   |               |                   |                   GetRegisterUserByToken.class
|   |   |               |                   |
|   |   |               |                   +---invalidate
|   |   |               |                   |   \---register
|   |   |               |                   |           InvalidateRegisterUserAfterTokenUsed.class
|   |   |               |                   |
|   |   |               |                   \---reset
|   |   |               |                       \---password
|   |   |               |                               ResetPasswordUserAndInvalidateTokenUsed.class
|   |   |               |
|   |   |               \---utils
|   |   |                   +---build
|   |   |                   |   \---message
|   |   |                   |       \---email
|   |   |                   |           \---html
|   |   |                   |                   BuildMessageInHtml.class
|   |   |                   |
|   |   |                   +---encryptedpassword
|   |   |                   |   |   EncryptedPassword.class
|   |   |                   |   |
|   |   |                   |   \---cfg
|   |   |                   |           PasswordConfiguration.class
|   |   |                   |
|   |   |                   +---generate
|   |   |                   |   +---token
|   |   |                   |   |   \---password
|   |   |                   |   |       \---recovery
|   |   |                   |   |               GenerateTokenPasswordRecovery.class
|   |   |                   |   |
|   |   |                   |   \---uri
|   |   |                   |           GenerateUri.class
|   |   |                   |
|   |   |                   +---get
|   |   |                   |   \---username
|   |   |                   |       \---by
|   |   |                   |           \---context
|   |   |                   |               \---security
|   |   |                   |                       GetUsernameByContextHolder.class
|   |   |                   |
|   |   |                   +---pageable
|   |   |                   |   +---factory
|   |   |                   |   |       PageableFactoryByClassReceived.class
|   |   |                   |   |
|   |   |                   |   +---fields
|   |   |                   |   |   \---name
|   |   |                   |   |       \---get
|   |   |                   |   |           \---use
|   |   |                   |   |               \---reflect
|   |   |                   |   |                   +---project
|   |   |                   |   |                   |       FieldsNameProject.class
|   |   |                   |   |                   |
|   |   |                   |   |                   \---user
|   |   |                   |   |                           FieldsNameUser.class
|   |   |                   |   |
|   |   |                   |   +---implementations
|   |   |                   |   |   +---project
|   |   |                   |   |   |       ImplementPageableProject.class
|   |   |                   |   |   |
|   |   |                   |   |   \---user
|   |   |                   |   |           ImplementPageableUser.class
|   |   |                   |   |
|   |   |                   |   +---interfaces
|   |   |                   |   |       PageableGenerator.class
|   |   |                   |   |
|   |   |                   |   \---logic
|   |   |                   |       \---default_
|   |   |                   |               PageableLogicDefault.class
|   |   |                   |
|   |   |                   +---parse
|   |   |                   |   \---data
|   |   |                   |       \---from
|   |   |                   |           \---iso
|   |   |                   |               \---american
|   |   |                   |                       ParseDataFromIsoAmerican.class
|   |   |                   |
|   |   |                   \---validation
|   |   |                       +---token
|   |   |                       |   \---from
|   |   |                       |       \---reset
|   |   |                       |           \---password
|   |   |                       |               \---is
|   |   |                       |                   +---expired
|   |   |                       |                   |       TokenPasswordIsExpired.class
|   |   |                       |                   |
|   |   |                       |                   \---used
|   |   |                       |                           TokenPasswordIsUsed.class
|   |   |                       |
|   |   |                       \---user
|   |   |                           +---is
|   |   |                           |   +---creator
|   |   |                           |   |   \---project
|   |   |                           |   |           UserRequestIsCreatorProject.class
|   |   |                           |   |
|   |   |                           |   \---role
|   |   |                           |       \---admin
|   |   |                           |               ValidationIfUserIsRoleAdmin.class
|   |   |                           |
|   |   |                           \---put
|   |   |                               \---them
|   |   |                                   \---selves
|   |   |                                           ValidationIfUserEffectPutThemSelves.class
|   |   |
|   |   \---db
|   |       \---migration
|   |               V1__Create_Table_Users.sql
|   |               V2__Create_Table_Register_Password_Users.sql
|   |               V3__Create_Table_Projects.sql
|   |               V4__Create_Table_Register_Password_Projects.sql




</pre>
</div>
<h2>Observações A Respeito Da Arquitetura</h2>
<p><strong>Optei pela arquitetura MVC porque, na minha visão como desenvolvedor, arquiteturas como DDD e a arquitetura hexagonal, embora extremamente poderosas, foram pensadas para softwares de grande porte, com alto nível de complexidade e múltiplas regras de negócio.</strong>

<strong>Acredito que a principal missão de um desenvolvedor é resolver o problema do usuário da forma mais eficiente possível, escolhendo as ferramentas adequadas para cada contexto</strong>, e não necessariamente a solução mais sofisticada. Nesse cenário, o MVC se mostrou a opção mais equilibrada, oferecendo simplicidade, boa manutenibilidade e uma estrutura amplamente adotada pelo mercado.

Na minha visão, uma arquitetura simples não limita a evolução do sistema; pelo contrário, ela estabelece uma base clara e sólida, permitindo que o software cresça de forma organizada conforme novas necessidades surgem.</p>



<p></p>

