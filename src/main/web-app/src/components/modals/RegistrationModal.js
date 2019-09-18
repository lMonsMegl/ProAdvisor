import React, { Component } from 'react';
import PropsTypes from 'prop-types';
import Button from '../Button';
import { emailValidator } from '../../utils/validators/emailValidator';
import { passwordValidator } from '../../utils/validators/passwordValidator';
import { notEmptyValidator } from '../../utils/validators/notEmptyValidator';
import { registerUser } from '../../actions/store/user';
import { connect } from 'react-redux';

class RegistrationModal extends Component {
  static propTypes = {
    onLogIn: PropsTypes.func.isRequired
  };

  constructor(props) {
    super(props);
    this.state = {
      name: '',
      nameValidation: false,
      surname: '',
      surnameValidation: false,
      email: '',
      emailValidation: false,
      password: '',
      passwordValidation: false,
      repeatPassword: '',
      repeatPasswordValidation: false,
      logIn: '',
      logInValidation: false,
      registrationPassed: false
    };
  }

  validateNewUser = () => {
    this.setState({
      nameValidation: !notEmptyValidator(this.state.name).valid,
      surnameValidation: !notEmptyValidator(this.state.surname).valid,
      logInValidation: !notEmptyValidator(this.state.logIn).valid,
      emailValidation: !emailValidator(this.state.email).valid,
      passwordValidation: !passwordValidator(this.state.password).valid,
      repeatPasswordValidation: !(passwordValidator(this.state.repeatPassword).valid && this.state.password === this.state.repeatPassword)
    }, () => {
      const conditions = [
        this.state.nameValidation,
        this.state.surnameValidation,
        this.state.logInValidation,
        this.state.emailValidation,
        this.state.passedEmailValidation,
        this.state.repeatPasswordValidation
      ];

      conditions.every(element => !element) && this.props.register({
            name: this.state.name,
            surname: this.state.surname,
            login: this.state.logIn,
            email: this.state.email,
            password: this.state.password,
            repeatPassword: this.state.repeatPassword
          }
      );
    });
  };

  render() {
    const { menuData } = this.props;

    return (
        <div className="modal-dialog" role="dialog">
          <div className="modal-content">
            <div className="modal-header">
              {menuData.REGISTRATION_MODAL.PURPOSE}
              <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div className="modal-body">
              <div className="register-input">
                <input type="text"
                       value={this.state.name}
                       placeholder={menuData.REGISTRATION_MODAL.NAME}
                       onChange={event => this.setState({ name: event.target.value })} required />
                {this.state.nameValidation && <div className="error-message">
                  {menuData.REGISTRATION_MODAL.REQUIRED_FIELD}
                </div>}
              </div>
              <div className="register-input">
                <input type="text"
                       value={this.state.surname}
                       placeholder={menuData.REGISTRATION_MODAL.SURNAME}
                       onChange={event => this.setState({ surname: event.target.value })} required />
                {this.state.surnameValidation && <div className="error-message">
                  {menuData.REGISTRATION_MODAL.REQUIRED_FIELD}
                </div>}
              </div>
              <div className="register-input">
                <input type="text"
                       value={this.state.logIn}
                       placeholder={menuData.REGISTRATION_MODAL.LOG_IN}
                       onChange={event => this.setState({ logIn: event.target.value })} required />
                {this.state.logInValidation && <div className="error-message">
                  {menuData.REGISTRATION_MODAL.REQUIRED_FIELD}
                </div>}
              </div>
              <div className="register-input">
                <input type="email"
                       value={this.state.email}
                       placeholder={menuData.REGISTRATION_MODAL.EMAIL}
                       onChange={event => this.setState({ email: event.target.value })} required />
                {this.state.emailValidation && <div className="error-message">
                  {menuData.REGISTRATION_MODAL.INVALID_EMAIL}
                </div>}
              </div>
              <div className="register-input">
                <input type="password"
                       placeholder={menuData.REGISTRATION_MODAL.PASSWORD}
                       value={this.state.password}
                       onChange={event => this.setState({ password: event.target.value })} required />
                {this.state.passwordValidation &&
                <div className="error-message">
                  {menuData.REGISTRATION_MODAL.INVALID_PASSWORD}
                </div>}
              </div>
              <div className="register-input">
                <input type="password"
                       placeholder={menuData.REGISTRATION_MODAL.REPEAT_PASSWORD}
                       value={this.state.repeatPassword}
                       onChange={event => this.setState({ repeatPassword: event.target.value })} required />
                {this.state.repeatPasswordValidation && (this.state.repeatPassword === this.state.password ?
                    <div className="error-message">
                      {menuData.REGISTRATION_MODAL.INVALID_PASSWORD}
                    </div>
                    : <div className="error-message">
                      {menuData.REGISTRATION_MODAL.INVALID_REPEAT_PASSWORD}
                    </div>)}
              </div>

            </div>
            <div className="modal-footer">
              {this.props.status === 200 && this.props.onLogIn()}
              <Button title={menuData.LOG_IN_MODAL.LOG_IN_BUTTON}
                      data-dismiss="modal"
                      className="btn btn-secondary"
                      onClick={this.props.onLogIn} />

              <Button className="btn btn-primary" title={menuData.LOG_IN_MODAL.REGISTER_BUTTON}
                      onClick={this.validateNewUser} />
            </div>
          </div>
        </div>
    );
  }
}

const mapStateToProps = store => ({
  status: store.user.status,
  menuData: store.languages.menuData
});

const mapDispatchToProps = dispatch => ({
  register: data => dispatch(registerUser(data))
});

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(RegistrationModal);
