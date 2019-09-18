import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { addChapter } from '../../actions/request/caterings';

class ChapterModal extends Component {
  static propTypes = {
    id: PropTypes.number.isRequired,
    update: PropTypes.func.isRequired
  };

  constructor(props) {
    super(props);
    this.state = {
      newChapter: '',
      notCompletedField: ''
    };
  }

  onAddChapter = () => {
    this.state.newChapter === '' ? this.setState({ notCompletedField: 'This field is required' })
        : addChapter(this.props.id, { name: this.state.newChapter })
            .then(() => this.props.update());
  };

  render() {
    const { newChapter } = this.state;

    return (
        <div className="modal fade" id="addChapterModal" tabIndex="-1" role="dialog"
             aria-labelledby="addChapterModalLabel" aria-hidden="true">
          <div className="modal-dialog" role="document">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title" id="addChapterModalLabel">Add Chapter</h5>
                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div className="modal-body">
                <input type="text"
                       placeholder="Chapter Name..."
                       value={newChapter}
                       onChange={event => this.setState({ newChapter: event.target.value })} />
                <div className="error-message">{this.state.notCompletedField}</div>
              </div>
              <div className="modal-footer">
                <button type="button"
                        className="btn btn-secondary"
                        data-dismiss="modal"
                        onClick={() => this.setState({})}>
                  Close
                </button>
                <button type="button"
                        className="btn btn-primary"
                        data-dismiss={this.state.newChapter !== '' && 'modal'}
                        onClick={this.onAddChapter}>Add
                </button>
              </div>
            </div>
          </div>
        </div>
    );
  }
}

export default ChapterModal;
