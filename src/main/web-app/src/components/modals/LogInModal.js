import React, { Component } from 'react';
import { connect } from 'react-redux';
import PropTypes from 'prop-types';
import { logInUser } from '../../actions/store/user';
import Button from '../Button';
import { notEmptyValidator } from '../../utils/validators/notEmptyValidator';
import RegistrationModal from './RegistrationModal';

class LogInModal extends Component {
  static propTypes = {
    signIn: PropTypes.func,
    registerIn: PropTypes.func,
    name: PropTypes.string
  };

  static defaultProps = {
    signIn: () => {
    },
    registerIn: () => {
    }
  };

  constructor(props) {
    super(props);
    this.state = {
      username: '',
      passedEmailValidation: true,
      password: '',
      passedPasswordValidation: true,
      displayLogIn: true
    };
  }

  logInUser = () => {
    const { username, password } = this.state;

    this.setState({
      passedEmailValidation: notEmptyValidator(username).valid,
      passedPasswordValidation: notEmptyValidator(password).valid
    }, () => {
      this.state.passedEmailValidation && this.state.passedPasswordValidation &&
      this.props.signIn({
            username: this.state.username,
            password: this.state.password
          }
      );
    });
  };

  logInRender() {
    const { username, password } = this.state;
    const { menuData } = this.props;

    return (
        <div className="modal-dialog" role="dialog">
          <div className="modal-content">
            <div className="modal-header">
              {menuData.LOG_IN_MODAL.GREETING}
              <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div className="modal-body">
              <div className="register-input">
                <input type="email"
                       placeholder={menuData.LOG_IN_MODAL.EMAIL}
                       value={username}
                       onChange={e => this.setState({ username: e.target.value })} />
                {!this.state.passedEmailValidation && <div className="error-message">
                  {menuData.LOG_IN_MODAL.WRONG_EMAIL_FORMAT}
                </div>}
              </div>
              <div className="register-input">
                <input type="password"
                       placeholder={menuData.LOG_IN_MODAL.PASSWORD}
                       value={password}
                       onChange={e => this.setState({
                         password: e.target.value
                       })} />
                {!this.state.passedPasswordValidation && <div className="error-message">
                  {menuData.LOG_IN_MODAL.REQUIRED_FIELD}
                </div>}
              </div>
            </div>
            <div className="modal-footer">
              <button data-dismiss={this.props.name !== '' && 'modal'}
                      className="btn btn-secondary"
                      onClick={this.logInUser}>
                {menuData.LOG_IN_MODAL.LOG_IN_BUTTON}
              </button>

              <Button className="btn btn-primary"   title={menuData.LOG_IN_MODAL.REGISTER_BUTTON}
                      onClick={() => this.setState({ displayLogIn: false })} />
            </div>
          </div>
        </div>
    );
  }

  render() {
    const { displayLogIn } = this.state;

    return (
        <div className="modal fade" id="logInModal" tabIndex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
          {
            displayLogIn ? this.logInRender() :
                <RegistrationModal onLogIn={() => this.setState({ displayLogIn: true })} />
          }
        </div>
    );
  }
}

const mapStateToProps = store => ({
  menuData: store.languages.menuData,
  name: store.user.name
});

const mapDispatchToProps = dispatch => ({
  signIn: data => dispatch(logInUser(data))
});

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(LogInModal);
